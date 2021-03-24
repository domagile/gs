package googlesheets.test.rd.comparetwosheets;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS011_duplicatesDeleteRowsWithinSelectionTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1aLi-r0mZz6yJEbyiid45z3hg6cKZ3psa4lKPT5KEHl0/edit#gid=35490700");
    }


    @Test
    public void duplicatesDeleteRowsWithinSelection() throws IOException {
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

        clickDeleteRowsWithinSelectionRadioButton();
        clickFinishAndClose();
        checkResult("Table1", "comparetwosheets\\CTS_011_duplicatesDeleteRowsWithinSelection.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo();
    }
}
