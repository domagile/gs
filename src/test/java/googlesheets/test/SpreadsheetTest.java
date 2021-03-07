package googlesheets.test;

import googlesheets.service.GoogleSheetService;
import org.junit.AfterClass;

import java.io.IOException;

public abstract class SpreadsheetTest {
    protected abstract String getSpreadsheetName();


    protected void checkResult(String listName, String etalonFileName) throws IOException, InterruptedException {
        GoogleSheetService.checkResult(getSpreadsheetName(), listName, etalonFileName);
    }


    @AfterClass
    //to fix issue that new document is not opened for the next test
    public static void pauseBeforeNextTest() throws InterruptedException {
        Thread.sleep(3000);
    }


    protected static String getSpreadsheetName(Class<?> clazz) {
        String className = clazz.getSimpleName();
        String rdrXXXString = className.substring(0, className.indexOf("_"));
        return rdrXXXString.substring(0, 3) + '_' + rdrXXXString.substring(3, 6);
    }
}
