package googlesheets.test.rd.comparetwosheets;

import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS001_duplicatesAddStatusTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1JsgI__dNB1HfF_0HgpzsXM3jedgx3bOmUBUydELJH_4/edit#gid=18691539");
    }


    @Test
    public void duplicatesAddStatus() {
        runCompareColumnsOrSheets();
        setCreateBackupCopyOfSheet(false);

        setStep1Range("D1:H8");
        clickNext();

        setStep2Range("C3:G10");
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
        checkResult("Table1", "comparetwosheets\\CTS_001_duplicatesAddStatus.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo();
    }
}
