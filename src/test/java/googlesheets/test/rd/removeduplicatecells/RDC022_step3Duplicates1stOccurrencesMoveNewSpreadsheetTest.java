package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.generic.addon.ResultInfo;
import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC022_step3Duplicates1stOccurrencesMoveNewSpreadsheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1j2-CLO1YFlPWkoEutlTBcJKrNDkseXAmeOP4LlH3-2w/edit#gid=1578032508");
    }


    @Test
    public void duplicates1stOccurrencesMoveNewSpreadsheet() throws IOException {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        setRange("A1:C35");
        clickNext();

        selectCellType(CellType.DUPLICATES_FIRST_OCCURRENCES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickMoveToAnotherLocation();
        clickNewSpreadsheet();
        clickFinish();
        ResultInfo resultInfo = waitForNewSpreadsheetAndClose();

        checkNewSpreadsheetResult("Master", "removeduplicatecells\\RDC_022 - duplicates1stOccurrencesMoveNewSpreadsheet.csv", resultInfo);

    }

    @Override
    protected void restoreInitialStateForNewSpreadsheetOption() {
        //todo: replace with some rollback through API
        clickUndo(10);
    }


}