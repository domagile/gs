package googlesheets.test.rd.removeduplicaterows;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR039_Step4duplicatesMoveCustomLocation extends RDRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1CRkEPKI39ygpPTLWbdgTn4xhZS2IO6rIxMyjLSL_bjQ/edit#gid=589970410");
    }


    @Test
    public void duplicatesMoveToAnotherLocation() throws IOException, InterruptedException {
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
        clickMoveToAnotherLocation();
        clickCustomLocation();

        setCustomLocationRange("'Master'!F1");

        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_039_step4duplicatesMoveCustomLocation.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        //todo: replace with some rollback through API
        clickUndo(10);
    }
}
