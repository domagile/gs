package googlesheets.test.generic;

import googlesheets.service.generic.google.GoogleSheetService;
import org.junit.AfterClass;
import org.junit.Before;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public abstract class AddonTest {

    protected String getSpreadsheetName()
    {
        String className = getClass().getSimpleName();
        String testXXXString = className.substring(0, className.indexOf("_"));
        final int testNumberLength = 3;
        int codeLength = testXXXString.length() - testNumberLength;
        return testXXXString.substring(0, codeLength) + '_' + testXXXString.substring(codeLength, codeLength + testNumberLength);
    }


    protected static void openDocument(String link) {
        GoogleSheetService.openDoc(link);
    }


    @Before
    public void openSpreadsheet() {
        GoogleSheetService.openSpreadsheetByName(getSpreadsheetName());
    }


    @AfterClass
    //to fix issue that new document is not opened for the next test
    public static void pauseBeforeNextTest() {
        sleep(3000);
    }
}
