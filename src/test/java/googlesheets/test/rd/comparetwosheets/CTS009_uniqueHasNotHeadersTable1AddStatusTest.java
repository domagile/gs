package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.removeduplicates.comparetwosheets.ColumnComparisonPair;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS009_uniqueHasNotHeadersTable1AddStatusTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1PRn2WpRc5Qg_ic_heEZ6l6a5snL4F28bPivBuptM5JY/edit#gid=1768414711");
    }


    @Test
    public void uniqueHasNotHeadersTable1AddStatus() {
        runCompareColumnsOrSheets();
        setCreateBackupCopyOfSheet(false);
        setStep1Range("C3:I9");
        clickNext();
        setStep2Range("E7:K14");
        clickNext();
        clickUniqueValuesRadioButton();
        clickNext();
        setTable1HasHeaders(false);
        setTable2HasHeaders(true);
        setSkipEmptyCells(false);
        setMatchCase(false);

        setColumnsToCompare(new ColumnComparisonPair(1, "ID"),
                new ColumnComparisonPair(2, "Fruit"),
                new ColumnComparisonPair(3, "Caloric value"));

        //clickAutoDetect();
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Table1", "comparetwosheets\\CTS_009_uniqueHasNotHeadersTable1AddStatus.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
