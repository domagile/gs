package googlesheets.test.rd.generic;

import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import googlesheets.service.technical.file.FileType;
import googlesheets.test.generic.AddonTest;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.technical.file.FileService.compareFileWithEtalon;
import static googlesheets.service.technical.file.FileService.removeDownloadedSheetFile;

public class RDTest extends AddonTest {
    protected void checkResult(String listName, String etalonFileName) {
        //fixme: refactor to invoke generic checks from checkResult()
        startCSVDownload();
        sleep(2000);
        restoreInitialDocumentState(listName);
        compareFileWithEtalon(getSpreadsheetName(), listName, etalonFileName);
        removeDownloadedSheetFile(getSpreadsheetName(), listName, FileType.CSV);
    }


    protected void restoreInitialDocumentState(String listName) {
    }


    protected void checkExcelResult(String listName, String etalonFileName) {
        //fixme: refactor to invoke generic checks from checkResult()
        startXLSXDownload();
        sleep(2000);
        restoreInitialDocumentState(listName);
        compareFileWithEtalon(getSpreadsheetName(), listName, etalonFileName, FileType.XLSX);
        removeDownloadedSheetFile(getSpreadsheetName(), listName, FileType.XLSX);
    }

    protected void checkNewSpreadsheetResult(String sourceListName, String etalonFileName, ResultInfo resultInfo) {
        restoreInitialStateForNewSpreadsheetOption();
        sleep(1000);
        openDocument(resultInfo.getNewSpreadsheetLink());
        startCSVDownload();
        sleep(2000);
        String listName = getFullSheetName(sourceListName);
        moveSpreadsheetToTrashThroughMenu();
        String newSpreadsheetName = String.format("%s - %s", getSpreadsheetName(), listName.substring(listName.indexOf('-') + 2));
        compareFileWithEtalon(newSpreadsheetName, listName, etalonFileName);
        removeDownloadedSheetFile(newSpreadsheetName, listName, FileType.CSV);
    }


    protected void restoreInitialStateForNewSpreadsheetOption()
    {
    }
}
