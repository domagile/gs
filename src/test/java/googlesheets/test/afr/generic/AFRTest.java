package googlesheets.test.afr.generic;

import googlesheets.service.generic.WebDriverService;
import googlesheets.service.technical.file.FileType;
import googlesheets.test.SpreadsheetTest;

import java.io.IOException;

import static googlesheets.service.technical.file.FileService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class AFRTest extends SpreadsheetTest {
    //todo: refactor to remove internals as much as possible and use generic method
    protected void checkResult(String resultListName, String etalonFile) {
        String spreadsheetName = getSpreadsheetName();
        if (fileExists(spreadsheetName, resultListName, FileType.CSV)) {
            throw new IllegalStateException(String.format("File for list %s already exists", resultListName));
        }
        WebDriverService.getInstance().getDriver().switchTo().defaultContent();
        makeSheetActive(resultListName);
        startCSVDownload();
        restoreInitialDocumentState(resultListName);
        compareFileWithEtalon(spreadsheetName, resultListName, etalonFile);
        removeDownloadedListFile(spreadsheetName, resultListName, FileType.CSV);
    }

    protected void restoreInitialDocumentState(String resultListName) {
        removeListThroughMenu(resultListName);
    }
}
