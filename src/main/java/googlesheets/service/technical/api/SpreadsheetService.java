package googlesheets.service.technical.api;

import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.services.drive.Drive;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.Sheet;
import com.google.api.services.sheets.v4.model.Spreadsheet;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static googlesheets.service.technical.api.Context.APPLICATION_NAME;

public class SpreadsheetService {
    private static final List<String> SCOPES = Arrays.asList(SheetsScopes.SPREADSHEETS_READONLY, SheetsScopes.DRIVE);


    public static void main(String[] args) throws GeneralSecurityException, IOException {
//        compareSheets();
//        deleteSpreadsheet("sdfldskfjlsdkjflskdjflsdjkflkjdlkfjslkjdflsdkjf");
    }


    public static void compareSheets(String spreadsheetId, String sheet1Name, String sheet2Name) throws GeneralSecurityException, IOException {
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, Context.getJsonFactory(),
                CredentialProvider.getCredentials(HTTP_TRANSPORT, SCOPES))
                .setApplicationName(APPLICATION_NAME)
                .build();
        Spreadsheet spreadsheet = service.spreadsheets().get(spreadsheetId).execute();
        Sheet sheet1 = getSheet(spreadsheet, sheet1Name).orElseThrow(IllegalArgumentException::new);
        Sheet sheet2 = getSheet(spreadsheet, sheet2Name).orElseThrow(IllegalArgumentException::new);
    }


    private static Optional<Sheet> getSheet(Spreadsheet spreadsheet, String sheetName) {
        return spreadsheet.getSheets().stream().filter(sheet -> sheet.getProperties().getTitle().equals(sheetName)).findFirst();
    }


    public static void deleteSpreadsheet(String fileId) {
        try {
            final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            Drive service = new Drive.Builder(HTTP_TRANSPORT, Context.getJsonFactory(), CredentialProvider.getCredentials(HTTP_TRANSPORT, SCOPES))
                    .setApplicationName(APPLICATION_NAME)
                    .build();
            service.files().delete(fileId).execute();
        }
        catch (GeneralSecurityException | IOException e) {
            throw new RuntimeException(e);
        }
    }
}
