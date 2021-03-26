package googlesheets.test.rd.comparetwosheets;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS029_table1AndTable3AddStatusTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1GTnlzXQbRzwlSxtPG4W3OkjmfYLYI8SZVUrfxqUKW7U/edit#gid=1545055448");
    }

    @Test
    public void uniqueTable1AndTable3AddStatus() throws IOException {
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
        checkResult(getResultListName("Table1"), "comparetwosheets\\CTS_029_uniqueTable1AndTable3AddStatus.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
