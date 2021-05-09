package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getFullSheetName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC033_step2UniquesMatchCaseSkipEmptyCellsTest extends RDCTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1MfBjouBPrXzzbqYHTnZI6rj_a3gkDnfY0qFL4jsohHk/edit#gid=1701814307");
    }


    @Test
    public void uniquesMatchCase() {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.UNIQUES);
        setMatchCase(true);
        setSkipEmptyCells(true);
        clickNext();

        clickFillWithColor();
        clickFinishAndClose();

        checkExcelResult(getFullSheetName("Master"), "removeduplicatecells\\RDC_033_uniquesMatchCaseSkipEmptyCells.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}
