package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC031_step2DuplicatesMatchCaseSkipEmptyCellsTest extends RDCTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/16ONfbpdKEcxY7452yDPe87nPK_j0G1IG4l7faT0rXHk/edit#gid=610516282");
    }


    @Test
    public void duplicatesMatchCase() throws IOException {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.DUPLICATES);
        setMatchCase(true);
        setSkipEmptyCells(true);
        clickNext();

        clickFillWithColor();

        clickFinishAndClose();

        checkExcelResult(getResultListName("Master"), "removeduplicatecells\\RDC_031_duplicatesMatchCaseSkipEmptyCells.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}
