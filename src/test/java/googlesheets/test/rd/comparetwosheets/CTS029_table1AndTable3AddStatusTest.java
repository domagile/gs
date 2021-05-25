package googlesheets.test.rd.comparetwosheets;

import org.junit.Ignore;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS029_table1AndTable3AddStatusTest extends CTSTest {
    @Ignore
    @Test
    public void uniqueTable1AndTable3AddStatus() {
        runCompareColumnsOrSheets();
        setCreateBackupCopyOfSheet(false);
        setStep1Range("C3:I10");
        clickNext();

        selectSecondSheet("Table3");
        setStep2Range("A1:G6");
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
        checkResult(getFullSheetName("Table1"), "comparetwosheets\\CTS_029_uniqueTable1AndTable3AddStatus.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
