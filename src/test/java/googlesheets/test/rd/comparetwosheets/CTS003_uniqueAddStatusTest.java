package googlesheets.test.rd.comparetwosheets;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS003_uniqueAddStatusTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1nA7SO5thwtn54aQ0b8qJkXig0Ea3QJtnmASOkYWTrpc/edit#gid=1143947967");
    }


    @Test
    public void uniqueAddStatus2equalColumns() throws IOException {
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
        checkResult("Table1", "comparetwosheets\\CTS_003_uniqueAddStatus.csv");
    }
    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo();
    }
}
