package googlesheets.test.afr.generic;

import googlesheets.service.WebDriverService;
import googlesheets.test.SpreadsheetTest;

import java.io.IOException;

import static googlesheets.service.FileService.*;
import static googlesheets.service.GoogleSheetService.*;

public class AFRTest extends SpreadsheetTest {
    @Override
    protected String getSpreadsheetName() {
        String className = getClass().getSimpleName();
        String afrXXXString = className.substring(0, className.indexOf("_"));
        return afrXXXString.substring(0, 3) + '_' + afrXXXString.substring(3, 6);
    }


    //todo: refactor to remove internals as much as possible and use generic method
    protected void checkResult(String resultListName, String etalonFile) throws IOException, InterruptedException {
        String spreadsheetName = getSpreadsheetName();
        if (fileExists(spreadsheetName, resultListName)) {
            throw new IllegalStateException(String.format("File for list %s already exists", resultListName));
        }
        WebDriverService.getInstance().getDriver().switchTo().defaultContent();
        makeSheetActive(resultListName);
        startCSVDownload();
        restoreInitialDocumentState(resultListName);
        compareFileWithEtalon(spreadsheetName, resultListName, etalonFile);
        removeDownloadedListFile(spreadsheetName, resultListName);
    }

    protected void restoreInitialDocumentState(String resultListName) throws InterruptedException {
        removeListThroughMenu(resultListName);
    }
}
