package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC021_step3DuplicatesMoveNewSpreadsheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1dXD029kdjaaFz_gEpAK_39rhrdWiapz0rHB3ZPdrDiQ/edit#gid=1526929986");
    }


    @Test
    public void duplicatesMoveNewSpreadsheet() {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        setRange("A1:C35");
        clickNext();

        selectCellType(CellType.DUPLICATES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickMoveToAnotherLocation();
        clickNewSpreadsheet();
        clickFinish();
        ResultInfo resultInfo = waitForNewSpreadsheetAndClose();

        checkNewSpreadsheetResult("Master", "removeduplicatecells\\RDC_021 - duplicatesMoveNewSpreadsheet.csv", resultInfo);
    }

    protected void restoreInitialStateForNewSpreadsheetOption() {
        //todo: replace with some rollback through API
        clickUndo(10);
    }
}
