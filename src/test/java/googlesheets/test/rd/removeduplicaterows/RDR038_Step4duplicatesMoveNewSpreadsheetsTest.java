package googlesheets.test.rd.removeduplicaterows;

import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR038_Step4duplicatesMoveNewSpreadsheetsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1F0Avevlm488cmNbsOlnUASWNs1THTvSEVU-ev7NFvB8/edit#gid=836680336");
    }


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
