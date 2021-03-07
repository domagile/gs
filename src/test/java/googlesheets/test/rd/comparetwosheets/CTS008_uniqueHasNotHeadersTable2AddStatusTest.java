package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.comparetwosheets.ColumnComparisonPair;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.clickUndo;
import static googlesheets.service.comparetwosheets.CompareTwoSheetsService.*;

public class CTS008_uniqueHasNotHeadersTable2AddStatusTest extends CTSTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1W1aR0-Kd5MkYf1udYrOt-2i392qi8sv1WhKQVgDpYZc/edit#gid=1375560400");
    }

    @Test
    public void uniqueAddStatusAllColumns() throws IOException, InterruptedException {
        runCompareColumnsOrSheets();
        setCreateBackupCopyOfSheet(false);
        setStep1Range("C3:G10");
        clickNext();
        setStep2Range("E8:I14");
        clickNext();
        clickUniqueValuesRadioButton();
        clickNext();
        setTable1HasHeaders(true);
        setTable2HasHeaders(false);
        setSkipEmptyCells(false);
        setMatchCase(false);
        setColumnsToCompare(new ColumnComparisonPair(1, "Column E"),
                new ColumnComparisonPair(2, "Column F"),
                new ColumnComparisonPair(3, "Column G"));
        //clickAutoDetect();
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Table1", "comparetwosheets\\CTS_008_uniqueAddStatus.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) throws InterruptedException {
        clickUndo(5);
    }
}
