package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR039_Step4duplicatesMoveCustomLocation extends RDRTest {
    @Test
    public void duplicatesMoveToAnotherLocation() {
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
        checkResult("Master", "removeduplicaterows\\RDR_039_step4duplicatesMoveCustomLocation.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        //todo: replace with some rollback through API
        clickUndo(10);
    }
}
