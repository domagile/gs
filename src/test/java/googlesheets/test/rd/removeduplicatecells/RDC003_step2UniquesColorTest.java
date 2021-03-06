package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getFullSheetName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC003_step2UniquesColorTest extends RDCTest {
    @Test
    public void uniquesColor() {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.UNIQUES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickFillWithColor();
        //setColor("#ff0000");
        clickFinishAndClose();

        checkExcelResult(getFullSheetName("Master"), "removeduplicatecells\\RDC_003_uniquesColor.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}
