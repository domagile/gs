package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.GoogleSheetService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.clickUndo;
import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS024_uniqueDeleteRowsWithinSelectionTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1gMvIznsnnyBkJliTZIN23sH22zgmzOixB0l9bOldTdI/edit#gid=1937313365");
    }

    @Test
    public void uniqueDeleteRowsWithinSelection() throws IOException {
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

        clickDeleteRowsWithinSelectionRadioButton();

        clickFinishAndClose();
         checkResult(getResultListName("Table1"), "comparetwosheets\\CTS_024_uniqueDeleteRowsWithinSelection.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(10);
    }
}
