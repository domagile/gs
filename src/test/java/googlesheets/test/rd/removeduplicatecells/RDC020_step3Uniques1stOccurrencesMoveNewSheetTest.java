package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.setRange;

public class RDC020_step3Uniques1stOccurrencesMoveNewSheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1ePE4Br1giMvanKsP5edQb1DOXLI9S0h1rtEALj2cevo/edit#gid=1047667495");
    }


    @Test
    public void uniques1stOccurrencesMoveNewSheet() {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        // freezes without sleep
        sleep(1000);
        setRange("A1:C25");
        clickNext();

        selectCellType(CellType.UNIQUES_FIRST_OCCURRENCES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickMoveToAnotherLocation();
        clickNewSheet();
        clickFinishAndClose();

        checkResult(getFullSheetName("Master - uniques"), "removeduplicatecells\\RDC_020_uniques1stOccurrencesMoveNewSheet.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(3);
    }
}
