package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC029_step2DuplicatesSkipEmptyCellsTest extends RDCTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1MHt7UwGMBrmUe5Hr8XQyZV5OPFm8nna1_oItb94t4vY/edit#gid=1274362238");
    }


    @Test
    public void duplicatesSkipEmptyCells() throws IOException {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.DUPLICATES);
        setMatchCase(false);
        setSkipEmptyCells(true);
        clickNext();

        clickFillWithColor();

        clickFinishAndClose();

        checkExcelResult(getResultListName("Master"), "removeduplicatecells\\RDC_029_duplicatesSkipEmptyCells.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}
