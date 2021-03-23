package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.technical.file.FileType;
import googlesheets.test.SpreadsheetTest;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.*;
import static googlesheets.service.technical.file.FileService.compareFileWithEtalon;
import static googlesheets.service.technical.file.FileService.removeDownloadedListFile;

public class CTSTest extends SpreadsheetTest {
    @Override
    protected String getSpreadsheetName() {
        return getSpreadsheetName(getClass());
    }


    protected void checkResult(String listName, String etalonFileName) throws IOException {
        //fixme: refactor to invoke generic checks from checkResult()
        startCSVDownload();
        sleep(2000);
        restoreInitialDocumentState(listName);
        compareFileWithEtalon(getSpreadsheetName(), listName, etalonFileName);
        removeDownloadedListFile(getSpreadsheetName(), listName, FileType.CSV);
    }


    protected void restoreInitialDocumentState(String resultListName) {
    }
}
