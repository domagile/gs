package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.comparetwosheets.ColumnComparisonPair;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.clickUndo;
import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.comparetwosheets.CompareTwoSheetsService.*;

public class CTS028_uniqueMatchCaseAddStatusTest extends CTSTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1xlRrD_f5irKVN0YRPjbwMKYxvU2rtzTilUEIJe8eVZA/edit#gid=1834627808");
    }

    @Test
    public void uniqueCopyToAnotherLocationNewSheet() throws IOException, InterruptedException {
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
        setMatchCase(true);
        setColumnsToCompare(new ColumnComparisonPair(1, "id"),
                new ColumnComparisonPair(2, "FRUIT"),
                new ColumnComparisonPair(5, "FaST"));
        clickNext();

        clickAddStatusColumnRadioButton();

        clickFinishAndClose();
        checkResult(getResultListName("Table1"), "comparetwosheets\\CTS_028_uniqueMatchCaseAddStatusTest.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) throws InterruptedException {
        clickUndo(5);
    }
}
