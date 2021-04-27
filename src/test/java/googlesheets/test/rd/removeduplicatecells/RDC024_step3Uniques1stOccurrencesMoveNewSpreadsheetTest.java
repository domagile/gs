package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC024_step3Uniques1stOccurrencesMoveNewSpreadsheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1XV2kxxDaddbdMJrTaX36WVRrJn5Gq-wAGzzU7V8n5lU/edit#gid=1237429779");
    }


    @Test
    public void uniques1stOccurrencesCopyNewSpreadsheet() {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        setRange("A1:C35");
        clickNext();

        selectCellType(CellType.UNIQUES_FIRST_OCCURRENCES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickMoveToAnotherLocation();
        clickNewSpreadsheet();
        clickFinish();
        ResultInfo resultInfo = waitForNewSpreadsheetAndClose();

        checkNewSpreadsheetResult("Master", "removeduplicatecells\\RDC_024 - uniques1stOccurrencesMoveNewSpreadsheet.csv", resultInfo);

    }
    @Override
    protected void restoreInitialStateForNewSpreadsheetOption() {
        //todo: replace with some rollback through API
        clickUndo(10);
    }

}
