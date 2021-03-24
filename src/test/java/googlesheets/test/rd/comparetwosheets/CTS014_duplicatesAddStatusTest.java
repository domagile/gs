package googlesheets.test.rd.comparetwosheets;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS014_duplicatesAddStatusTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1cpyWr9r2aRxAt13-W7oU2j8Hyu4dgmfulmoAaKYl4go/edit#gid=1715970123");
    }

    @Test
    public void duplicatesAddStatus() throws IOException {
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

        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Table1", "comparetwosheets\\CTS_014_duplicatesAddStatus.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo();
    }
}
