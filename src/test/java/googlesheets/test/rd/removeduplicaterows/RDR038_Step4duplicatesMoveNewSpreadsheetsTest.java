package googlesheets.test.rd.removeduplicaterows;

import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR038_Step4duplicatesMoveNewSpreadsheetsTest extends RDRTest {
    @Test
    public void duplicatesMoveNewSpreadsheets() {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        clickDuplicatesRadioButton();
        clickNext();

        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1,2,3);
        clickNext();

        clickMoveToAnotherLocation();
        clickNewSpreadsheet();
        clickFinish();

        ResultInfo resultInfo = waitForNewSpreadsheetAndClose();

        checkNewSpreadsheetResult("Master", "removeduplicaterows\\RDR_038 - duplicatesMoveNewSpreadsheets.csv", resultInfo);
    }


    @Override
    protected void restoreInitialStateForNewSpreadsheetOption() {
        super.restoreInitialStateForNewSpreadsheetOption();
        clickUndo();
    }
}
