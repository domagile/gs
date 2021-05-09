package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC007_step2UniquesCopyNewSheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument()  {
        openDocument("https://docs.google.com/spreadsheets/d/1CBbebfj_XPza-cmjmLrryenW-_cm05SmUTTSeCdXVsg/edit#gid=1270754036");
    }


    @Test
    public void uniquesCopyNewSheet() {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.UNIQUES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickCopyToAnotherLocation();
        clickNewSheet();
        clickFinishAndClose();

        checkResult(getFullSheetName("Master - uniques"), "removeduplicatecells\\RDC_007_uniquesCopyNewSheet.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}
