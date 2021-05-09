package googlesheets.test.rd.comparetwosheets;

import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getFullSheetName;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS023_uniqueClearValuesTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1DDCYrPn75cMgxWZAWo5p9Q77TC-6YyD53MJ3u1z5zWI/edit#gid=1821560764");
    }

    @Test
    public void uniqueClearValues() {
        runCompareColumnsOrSheets();
        setCreateBackupCopyOfSheet(false);
        setStep1Range("C3:I10");
        clickNext();

        setStep2Range("E7:K14");
        clickNext();

        clickUniqueValuesRadioButton();
        clickNext();

        setTable1HasHeaders(true);
        setTable2HasHeaders(true);
        setSkipEmptyCells(false);
        setMatchCase(false);
        clickAutoDetect();
        clickNext();

        clickClearValuesRadioButton();
        clickFinishAndClose();
         checkResult(getFullSheetName("Table1"), "comparetwosheets\\CTS_023_uniqueClearValues.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(10);
    }
}
