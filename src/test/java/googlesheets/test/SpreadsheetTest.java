package googlesheets.test;

import googlesheets.service.generic.google.GoogleSheetService;
import org.junit.AfterClass;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public abstract class SpreadsheetTest {
    protected abstract String getSpreadsheetName();


    protected static void openDocument(String link) {
        GoogleSheetService.openDoc(link);
    }


    protected void checkResult(String listName, String etalonFileName) throws IOException {
        GoogleSheetService.checkResult(getSpreadsheetName(), listName, etalonFileName);
    }


    @AfterClass
    //to fix issue that new document is not opened for the next test
    public static void pauseBeforeNextTest() {
        sleep(3000);
    }


    protected static String getSpreadsheetName(Class<?> clazz) {
        String className = clazz.getSimpleName();
        String rdrXXXString = className.substring(0, className.indexOf("_"));
        return rdrXXXString.substring(0, 3) + '_' + rdrXXXString.substring(3, 6);
    }
}
