package googlesheets.test.rd.comparetwosheets;

import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getFullSheetName;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS018_duplicatesMoveNewSheetTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1k2GJ5nf1Bmd9e7q0Nz5MT25xq-o8lB4yLqBPoAOEMoY/edit#gid=935628022");
    }

    @Test
    public void duplicatesMoveToNewSheet() {
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

        clickMoveToAnotherLocation();
        clickNewSheet();

        clickFinishAndClose();
        checkResult(getFullSheetName("Table1 - duplicates"), "comparetwosheets\\CTS_018_duplicatesMoveToNewSheet.csv");
    }

   /* @Override
    protected void restoreInitialDocumentState(String resultListName) {
        //fixme: replace with undo
        removeListThroughMenu(resultListName);
    }*/

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
