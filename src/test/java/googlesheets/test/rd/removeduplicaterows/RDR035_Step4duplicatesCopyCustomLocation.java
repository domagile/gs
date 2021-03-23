package googlesheets.test.rd.removeduplicaterows;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR035_Step4duplicatesCopyCustomLocation extends RDRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/10M6PgSd7Qd1Sk2EgVnugloW698XWgN2iVuY6ZnnwxC8/edit#gid=1413370339");
    }


    @Test
    public void duplicatesAllColumnsCopyAnotherLocation() throws IOException, InterruptedException {
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
        clickCustomLocation();

        setCustomLocationRange("'Sheet1'!A1");
        clickFinishAndClose();
        checkResult("Sheet1", "removeduplicates\\RDR_035_step4duplicatesCopyAnotherLocationTest.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        //todo: replace with some rollback through API
        clickUndo(10);
    }
}
