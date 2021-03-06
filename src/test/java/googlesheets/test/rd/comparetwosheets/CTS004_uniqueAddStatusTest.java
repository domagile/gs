package googlesheets.test.rd.comparetwosheets;

import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS004_uniqueAddStatusTest extends CTSTest {
    @Test
    public void uniqueAddStatusAllColumns() {
        runCompareColumnsOrSheets();
        setCreateBackupCopyOfSheet(false);
        setStep1Range("C3:G10");
        clickNext();
        setStep2Range("E7:I14");
        clickNext();
        clickUniqueValuesRadioButton();
        clickNext();
        setTable1HasHeaders(true);
        setTable2HasHeaders(true);
        setSkipEmptyCells(false);
        setMatchCase(false);
        clickAutoDetect();
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Table1", "comparetwosheets\\CTS_004_uniqueAddStatus.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(2);
    }
}
