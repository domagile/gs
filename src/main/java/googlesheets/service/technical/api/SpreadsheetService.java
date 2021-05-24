package googlesheets.service.technical.api;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.model.File;
import com.google.api.services.drive.model.FileList;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.api.services.sheets.v4.model.Spreadsheet;
import googlesheets.service.GlobalContext;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static googlesheets.service.technical.api.Context.APPLICATION_NAME;
import static org.junit.Assert.fail;

public class SpreadsheetService {
    private static final String MIME_TYPE_SPREADSHEET = "application/vnd.google-apps.spreadsheet";
    private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY, SheetsScopes.DRIVE);


    public static void main(String[] args) throws GeneralSecurityException, IOException {
//        compareSheets();
//        deleteSpreadsheet("sdfldskfjlsdkjflskdjflsdjkflkjdlkfjslkjdflsdkjf");
        List<File> spt_002 = getSpreadsheetsByName("SPT_002");
        System.out.println(spt_002);
    }


    public static void compareSheets(String spreadsheetId, String sheet1Name, String sheet2Name) {
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Sheets service = new Sheets.Builder(HTTP_TRANSPORT, Context.getJsonFactory(),
                    CredentialProvider.getCredentials(HTTP_TRANSPORT, SCOPES))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            Spreadsheet spreadsheet = service.spreadsheets().get(spreadsheetId).setIncludeGridData(true).execute();
            Sheet sheet1 = getSheet(spreadsheet, sheet1Name).orElseThrow(IllegalArgumentException::new);
            Sheet sheet2 = getSheet(spreadsheet, sheet2Name).orElseThrow(IllegalArgumentException::new);
            List<String> diffs = new SheetComparator().compare(sheet1, sheet2);
            if (!diffs.isEmpty()) {
                fail(String.join("\n", diffs));
            }
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static Optional<Sheet> getSheet(Spreadsheet spreadsheet, String sheetName) {
        return spreadsheet.getSheets().stream().filter(sheet -> sheet.getProperties().getTitle().equals(sheetName)).findFirst();
    }


    public static void deleteSpreadsheet(String fileId) {
        try {
            Drive service = getDriveService();
            service.files().delete(fileId).execute();
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static Drive getDriveService() throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Drive service = new Drive.Builder(HTTP_TRANSPORT, Context.getJsonFactory(), CredentialProvider.getCredentials(HTTP_TRANSPORT, SCOPES))
                .setApplicationName(APPLICATION_NAME)
                .build();
        return service;
    }


    public static String getSpreadsheetIdByName(String name) {
        try {
            Drive driveService = getDriveService();

            String query = String.format("name = '%s' and mimeType = '%s'", name, MIME_TYPE_SPREADSHEET);
            FileList result = driveService.files().list().setQ(query).setSpaces("drive")
                    .setIncludeItemsFromAllDrives(true).setSupportsAllDrives(true)
                    //two options to get access to files of other users
                    .setCorpora("drive").setDriveId(GlobalContext.DRIVE_ID_TEST_CASES)
                    //Only mentioned fields are fetched for result: id, name, createdTime, mimeType
                    .setFields("files(id, name, mimeType)")
                    .execute();
            List<File> files = result.getFiles();
            if (files.size() != 1) {
                throw new RuntimeException("Unexpected number of spreadsheets: " + files.size());
            }
            return files.get(0).getId();
        } catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }
    }


    private static List<File> getSpreadsheetsByName(String name) throws IOException, GeneralSecurityException {
        Drive driveService = getDriveService();

        String pageToken = null;
        List<File> list = new ArrayList<>();
        String query = String.format("name = '%s' and mimeType = '%s'", name, MIME_TYPE_SPREADSHEET);

        do {
            FileList result = driveService.files().list().setQ(query).setSpaces("drive")
                    .setIncludeItemsFromAllDrives(true).setSupportsAllDrives(true)
                    //Only mentioned fields are fetched for result: id, name, createdTime, mimeType
                    .setFields("nextPageToken, files(id, name, createdTime, mimeType)")
                    .setPageToken(pageToken).execute();
            list.addAll(result.getFiles());
            pageToken = result.getNextPageToken();
        } while (pageToken != null);
        return list;
    }
}
