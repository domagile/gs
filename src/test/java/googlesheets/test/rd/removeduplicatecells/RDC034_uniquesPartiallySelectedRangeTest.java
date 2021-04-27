package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC034_uniquesPartiallySelectedRangeTest extends RDCTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/15X0AlkM2dcO7f3cIu4cjmoERfob80V42iUawd00Lxww/edit#gid=404252165");
    }


    @Test
    public void uniquesMatchCase() {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        setRange("A1:C35");
        clickNext();

        selectCellType(CellType.UNIQUES);
        setMatchCase(true);
        setSkipEmptyCells(true);
        clickNext();

        clickFillWithColor();
        clickFinishAndClose();

        checkExcelResult(getResultListName("Master"), "removeduplicatecells\\RDC_034_uniquesPartiallySelectedRange.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}
