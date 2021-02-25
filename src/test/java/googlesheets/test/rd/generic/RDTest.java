package googlesheets.test.rd.generic;

import googlesheets.test.SpreadsheetTest;

import java.io.IOException;

import static googlesheets.service.FileService.compareFileWithEtalon;
import static googlesheets.service.FileService.removeDownloadedListFile;
import static googlesheets.service.GoogleSheetService.*;

public abstract class RDTest extends SpreadsheetTest {
    @Override
    protected String getSpreadsheetName() {
        String className = getClass().getSimpleName();
        String rdrXXXString = className.substring(0, className.indexOf("_"));
        return rdrXXXString.substring(0, 3) + '_' + rdrXXXString.substring(3, 6);
    }


    protected void checkResult(String listName, String etalonFileName) throws IOException, InterruptedException {
        //fixme: refactor to invoke generic checks from checkResult()
        startCSVDownload();
        Thread.sleep(2000);
        restoreInitialDocumentState(listName);
        compareFileWithEtalon(getSpreadsheetName(), listName, etalonFileName);
        removeDownloadedListFile(getSpreadsheetName(), listName);
    }


    protected void restoreInitialDocumentState(String resultListName) throws InterruptedException {
        clickUndo();
    }
}
