package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR037_Step4duplicatesMoveNewSheetTest extends RDRTest {
    @Test
    public void duplicatesAllColumnsCopyNewSheet() {
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
        clickNewSheet();

        clickFinishAndClose();
        checkResult(getFullSheetName("Master - duplicates"), "removeduplicaterows\\RDR_037_step4duplicatesMoveNewSheet.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(15);
    }
}
