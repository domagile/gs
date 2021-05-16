package googlesheets.service.generic.addon.resultchecker;

import googlesheets.service.GlobalContext;
import googlesheets.service.technical.file.FileType;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.technical.file.FileService.*;
import static googlesheets.ui.generic.google.SpreadsheetMainMenuUtil.*;

public class ResultCheckerImpl implements ResultChecker {
    private String etalonDir;

    public ResultCheckerImpl(String etalonDir) {
        this.etalonDir = etalonDir;
    }


    public void checkResult(String spreadsheetName, String sheetName) {
        startCSVDownload();
        sleep(2000);
        compareFileWithEtalon(spreadsheetName, sheetName, getEtalonFileName(spreadsheetName, FileType.CSV));
        removeDownloadedSheetFile(spreadsheetName, sheetName, FileType.CSV);
    }


    public void checkExcelResult(String spreadsheetName, String sheetName) {
        if (fileExists(spreadsheetName, sheetName, FileType.XLSX)) {
            throw new IllegalStateException(String.format("File for list %s already exists", sheetName));
        }
        startXLSXDownload();
        sleep(2000);
        compareFileWithEtalon(spreadsheetName, sheetName, getEtalonFileName(spreadsheetName, FileType.XLSX), FileType.XLSX);
        removeDownloadedSheetFile(spreadsheetName, sheetName, FileType.XLSX);
    }


    public void checkNewSpreadsheetResult(ResultInfo resultInfo, String spreadsheetName, String resultSheetNamePart) {
        sleep(1000);
        openDoc(resultInfo.getNewSpreadsheetLink());
        startCSVDownload();
        sleep(2000);
        String sheetName = getFullSheetName(resultSheetNamePart);
        if (GlobalContext.USE_SPREADSHEET_API) {
            deleteSpreadsheet(getSpreadsheetId(resultInfo.getNewSpreadsheetLink()));
        }
        else {
            moveSpreadsheetToTrash();
        }
        String newSpreadsheetName = "New spreadsheet";
        compareFileWithEtalon(newSpreadsheetName, sheetName, getEtalonFileName(spreadsheetName, FileType.CSV));
        removeDownloadedSheetFile(newSpreadsheetName, sheetName, FileType.CSV);
    }


    private String getSpreadsheetId(String link) {
        String[] parts = link.split("/");
        return parts[parts.length - 2];
    }


    private String getEtalonFileName(String spreadsheetName, FileType fileType) {
        return etalonDir + spreadsheetName + '.' + fileType.name().toLowerCase();
    }
}
