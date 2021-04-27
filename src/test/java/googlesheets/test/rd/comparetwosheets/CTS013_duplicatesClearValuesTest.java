package googlesheets.test.rd.comparetwosheets;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS013_duplicatesClearValuesTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1bGQ7fqAywf-v91v3u63pvTQp-VzoH8kn8IWsmgHyvvE/edit#gid=785503451");
    }

    @Test
    public void duplicatesClearValues() {
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

        clickClearValuesRadioButton();
        clickFinishAndClose();
        checkResult("Table1", "comparetwosheets\\CTS_013_duplicatesClearValues.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo();
    }
}
