package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.clickUndo;
import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.setRange;

public class RDC019_step3UniquesMoveNewSheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1HCUkvtXHoZ0FbARUndytGUaCTGkdwSJVtZ0UyjjLHFw/edit#gid=1142594043");
    }


    @Test
    public void uniquesMoveNewSheet() throws IOException {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        setRange("A1:C25");
        clickNext();

        selectCellType(CellType.UNIQUES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickMoveToAnotherLocation();
        clickNewSheet();
        clickFinishAndClose();

        checkResult(getResultListName("Master - uniques"), "removeduplicatecells\\RDC_019_uniquesMoveNewSheet.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(3);
    }
}