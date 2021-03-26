package googlesheets.test.rd.removeduplicaterows;

import googlesheets.service.generic.addon.ResultInfo;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR036_Step4duplicatesCopyNewSpreadsheetsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1RtPu5P8-JNRqhfs6H4DVlKMAkoAuwd1VPK5ZA7UBlYI/edit#gid=1976388577");
    }


    @Test
    public void duplicatesCopyNewSpreadsheets() throws IOException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        clickDuplicatesRadioButton();
        clickNext();

        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1,2,3);
        clickNext();

        clickCopyToAnotherLocation();
        clickNewSpreadsheet();
        clickFinish();

        ResultInfo resultInfo = waitForNewSpreadsheetAndClose();

        checkNewSpreadsheetResult("Master", "removeduplicaterows\\RDR_036 - duplicatesCopyNewSpreadsheet.csv", resultInfo);
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        //todo: replace with some rollback through API
        clickUndo(10);
    }
}
