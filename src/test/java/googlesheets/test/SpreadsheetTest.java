package googlesheets.test;

import googlesheets.service.GoogleSheetService;

import java.io.IOException;

public abstract class SpreadsheetTest {
    protected abstract String getSpreadsheetName();


    protected void checkResult(String listName, String etalonFileName) throws IOException, InterruptedException {
        GoogleSheetService.checkResult(getSpreadsheetName(), listName, etalonFileName);
    }
}
