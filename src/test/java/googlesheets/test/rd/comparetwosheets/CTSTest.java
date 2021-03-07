package googlesheets.test.rd.comparetwosheets;

import googlesheets.test.SpreadsheetTest;

import java.io.IOException;

import static googlesheets.service.FileService.compareFileWithEtalon;
import static googlesheets.service.FileService.removeDownloadedListFile;
import static googlesheets.service.GoogleSheetService.clickUndo;
import static googlesheets.service.GoogleSheetService.startCSVDownload;

public class CTSTest extends SpreadsheetTest {
    @Override
    protected String getSpreadsheetName() {
        return getSpreadsheetName(getClass());
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
    }
}
