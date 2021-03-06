package googlesheets.test.rd.comparetwosheets;

import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.setCustomLocationRange;

public class CTS017_duplicatesCopyCustomLocationTest extends CTSTest {
    @Test
    public void duplicatesCopyCustomLocation() {
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

        clickCopyToAnotherLocation();
        clickCustomLocation();
        setCustomLocationRange("'Table1'!K1");

        clickFinishAndClose();
        checkResult(getFullSheetName("Table1"), "comparetwosheets\\CTS_017_duplicatesCopyCustomLocation.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
