package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS019_duplicatesMoveNewSpreadsheetTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/19bekO3172gfy4pFoRE4laGLVfG_WpSkpFhWaye2gJv0/edit#gid=645233142");
    }

    @Test
    public void duplicatesMoveToNewSpreadsheet() {
        runCompareColumnsOrSheets();
        setCreateBackupCopyOfSheet(false);
        setStep1Range("C3:I10");
        clickNext();

        setStep2Range("E7:K14");
        clickNext();

        clickDuplicateValuesRadioButton();
        clickNext();

        setTable1HasHeaders(true);
        setTable2HasHeaders(true);
        setSkipEmptyCells(false);
        setMatchCase(false);
        clickAutoDetect();
        clickNext();

        clickMoveToAnotherLocation();
        clickNewSpreadsheet();

        clickFinish();
        ResultInfo resultInfo = waitForNewSpreadsheetAndClose();
        checkNewSpreadsheetResult("Table1", "comparetwosheets\\CTS_019 - duplicatesMoveToNewSpreadsheet.csv", resultInfo);
    }

    protected void restoreInitialStateForNewSpreadsheetOption() {
        super.restoreInitialStateForNewSpreadsheetOption();
        clickUndo();
    }
}

