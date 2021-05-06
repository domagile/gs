package googlesheets.test.rd.comparetwosheets;

import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultSheetName;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS025_uniqueCopyNewSheetTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1PqxB4EB39kbJWntslmyGKVpLHEYO2hDxO5mvPxXfrdw/edit#gid=875607821");
    }

    @Test
    public void uniqueCopyToAnotherLocationNewSheet() {
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

        clickCopyToAnotherLocation();
        clickNewSheet();

        clickFinishAndClose();
        checkResult(getResultSheetName("Table1 - uniques"), "comparetwosheets\\CTS_025_uniqueCopyNewSheet.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(10);
    }
}
