package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.GoogleSheetService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.*;
import static googlesheets.service.comparetwosheets.CompareTwoSheetsService.*;

public class CTS029_table1AndTable3AddStatus extends CTSTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1GTnlzXQbRzwlSxtPG4W3OkjmfYLYI8SZVUrfxqUKW7U/edit#gid=1545055448");
    }

    @Test
    public void uniqueTable1AndTable3AddStatus() throws IOException, InterruptedException {
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
    protected void restoreInitialDocumentState(String resultListName) throws InterruptedException {
        clickUndo(5);
    }
}
