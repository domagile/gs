package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC032_step2UniquesMatchCaseSkipEmptyCellsTest extends RDCTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1VTCBiF-aPuNCnVWxCNhfxAFGwAWgKmmXBpu-8ff37Y4/edit#gid=582347370");
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

        checkExcelResult(getResultListName("Master"), "removeduplicatecells\\RDC_032_uniquesMatchCaseSkipEmptyCells.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}
