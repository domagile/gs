package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC008_step2Uniques1stOccurrencesCopyNewSheetTest extends RDRTest {
    @Test
    public void uniques1stOccurrencesCopyNewSheet() {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.UNIQUES_FIRST_OCCURRENCES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickCopyToAnotherLocation();
        clickNewSheet();
        clickFinishAndClose();

        checkResult(getFullSheetName("Master - uniques"), "removeduplicatecells\\RDC_008_uniques1stOccurrencesCopyNewSheet.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}
