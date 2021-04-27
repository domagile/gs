package googlesheets.test.rd.generic;

import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import googlesheets.service.technical.file.FileType;
import googlesheets.test.generic.SpreadsheetTest;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.technical.file.FileService.compareFileWithEtalon;
import static googlesheets.service.technical.file.FileService.removeDownloadedListFile;

public class RDTest extends SpreadsheetTest {
    protected void checkResult(String listName, String etalonFileName) {
        //fixme: refactor to invoke generic checks from checkResult()
        startCSVDownload();
        sleep(2000);
        restoreInitialDocumentState(listName);
        compareFileWithEtalon(getSpreadsheetName(), listName, etalonFileName);
        removeDownloadedListFile(getSpreadsheetName(), listName, FileType.CSV);
    }


    protected void restoreInitialDocumentState(String listName) {
    }


    protected void checkExcelResult(String listName, String etalonFileName) {
        //fixme: refactor to invoke generic checks from checkResult()
        startXLSXDownload();
        sleep(2000);
        restoreInitialDocumentState(listName);
        compareFileWithEtalon(getSpreadsheetName(), listName, etalonFileName, FileType.XLSX);
        removeDownloadedListFile(getSpreadsheetName(), listName, FileType.XLSX);
    }

    protected void checkNewSpreadsheetResult(String sourceListName, String etalonFileName, ResultInfo resultInfo) {
        restoreInitialStateForNewSpreadsheetOption();
        sleep(1000);
        openDocument(resultInfo.getNewSpreadsheetLink());
        startCSVDownload();
        sleep(2000);
        String listName = getResultListName(sourceListName);
        moveSpreadsheetToTrash();
        String newSpreadsheetName = String.format("%s - %s", getSpreadsheetName(), listName.substring(listName.indexOf('-') + 2));
        compareFileWithEtalon(newSpreadsheetName, listName, etalonFileName);
        removeDownloadedListFile(newSpreadsheetName, listName, FileType.CSV);
    }


    protected void restoreInitialStateForNewSpreadsheetOption()
    {
    }
}
