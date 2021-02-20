package googlesheets.test.afr.generic;

import googlesheets.test.SpreadsheetTest;

public class AFRTest extends SpreadsheetTest {
    @Override
    protected String getSpreadsheetName() {
        String className = getClass().getSimpleName();
        String afrXXXString = className.substring(0, className.indexOf("_"));
        return afrXXXString.substring(0, 3) + '_' + afrXXXString.substring(3, 6);
    }

}
