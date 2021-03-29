package googlesheets.test.rd.removeduplicatecells.generic;

import googlesheets.service.technical.file.FileType;
import googlesheets.test.SpreadsheetTest;

import java.io.IOException;

import static googlesheets.service.technical.file.FileService.compareFileWithEtalon;
import static googlesheets.service.technical.file.FileService.removeDownloadedListFile;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public abstract class RDCTest extends SpreadsheetTest {
    protected void checkResult(String listName, String etalonFileName) {
        //fixme: refactor to invoke generic checks from checkResult()
        startCSVDownload();
        sleep(2000);
        restoreInitialDocumentState(listName);
        compareFileWithEtalon(getSpreadsheetName(), listName, etalonFileName);
        removeDownloadedListFile(getSpreadsheetName(), listName, FileType.CSV);
    }

    protected void checkExcelResult(String listName, String etalonFileName) throws IOException {
        //fixme: refactor to invoke generic checks from checkResult()
        startXLSXDownload();
        sleep(2000);
        restoreInitialDocumentState(listName);
        compareFileWithEtalon(getSpreadsheetName(), listName, etalonFileName, FileType.XLSX);
        removeDownloadedListFile(getSpreadsheetName(), listName, FileType.XLSX);
    }


    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}

