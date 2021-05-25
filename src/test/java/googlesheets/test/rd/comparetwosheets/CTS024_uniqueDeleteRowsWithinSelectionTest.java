package googlesheets.test.rd.comparetwosheets;

import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getFullSheetName;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS024_uniqueDeleteRowsWithinSelectionTest extends CTSTest {
    @Test
    public void uniqueDeleteRowsWithinSelection() {
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

        clickDeleteRowsWithinSelectionRadioButton();

        clickFinishAndClose();
         checkResult(getFullSheetName("Table1"), "comparetwosheets\\CTS_024_uniqueDeleteRowsWithinSelection.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(10);
    }
}
