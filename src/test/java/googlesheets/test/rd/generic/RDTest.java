package googlesheets.test.rd.generic;

import googlesheets.test.SpreadsheetTest;

import java.io.IOException;

import static googlesheets.service.FileService.compareFileWithEtalon;
import static googlesheets.service.FileService.removeDownloadedListFile;
import static googlesheets.service.GoogleSheetService.startCSVDownload;
import static googlesheets.service.removeduplicates.RemoveDuplicatesService.clickUndo;

public abstract class RDTest extends SpreadsheetTest {
    @Override
    protected String getSpreadsheetName() {
        String className = getClass().getSimpleName();
        String rdrXXXString = className.substring(0, className.indexOf("_"));
        return rdrXXXString.substring(0, 3) + '_' + rdrXXXString.substring(3, 6);
    }


    protected void checkResult(String listName, String etalonFileName) throws IOException, InterruptedException {
        startCSVDownload();
        Thread.sleep(2000);
        clickUndo();
        compareFileWithEtalon(getSpreadsheetName(), listName, etalonFileName);
        removeDownloadedListFile(getSpreadsheetName(), listName);
    }
}
