package googlesheets.test.rd.removeduplicaterows.generic;

import googlesheets.service.generic.addon.ResultInfo;
import googlesheets.service.technical.file.FileType;
import googlesheets.test.SpreadsheetTest;

import java.io.IOException;

import static googlesheets.service.technical.file.FileService.compareFileWithEtalon;
import static googlesheets.service.technical.file.FileService.removeDownloadedListFile;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public abstract class RDRTest extends SpreadsheetTest {
    @Override
    protected String getSpreadsheetName() {
        return getSpreadsheetName(getClass());
    }


    protected void checkResult(String listName, String etalonFileName) throws IOException {
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

    protected void checkNewSpreadsheetResult(String sourceListName, String etalonFileName, ResultInfo resultInfo) throws IOException {
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

    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }


    protected void restoreInitialStateForNewSpreadsheetOption()
    {
    }
}


