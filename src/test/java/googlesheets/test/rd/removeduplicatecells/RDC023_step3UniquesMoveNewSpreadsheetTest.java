package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.generic.addon.ResultInfo;
import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC023_step3UniquesMoveNewSpreadsheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument()  {
        openDocument("https://docs.google.com/spreadsheets/d/1N_SeJx-MKvM_dYmWC9NCVt35TZdmT1wnQoRXeoB3-64/edit#gid=1025055528");
    }


    @Test
    public void uniquesCopyNewSpreadsheet() throws IOException {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        setRange("A1:C35");
        clickNext();

        selectCellType(CellType.UNIQUES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickMoveToAnotherLocation();
        clickNewSpreadsheet();
        clickFinish();
        ResultInfo resultInfo = waitForNewSpreadsheetAndClose();

        checkNewSpreadsheetResult("Master", "removeduplicatecells\\RDC_023 - uniquesMoveNewSpreadsheet.csv", resultInfo);
    }

    @Override
    protected void restoreInitialStateForNewSpreadsheetOption() {
        //todo: replace with some rollback through API
        clickUndo(10);
    }


}