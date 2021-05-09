package googlesheets.test.rd.comparetwosheets;

import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.setCustomLocationRange;

public class CTS020_duplicatesMoveCustomLocationTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1Fpo8Dojm3E-IQKNUrpxTD6ZkqQW3dPzrk6Axit1Bois/edit#gid=315044403");
    }

    @Test
    public void duplicatesMoveCustomLocation() {
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
        clickCustomLocation();
        setCustomLocationRange("'Table1'!K1");

        clickFinishAndClose();
        checkResult(getFullSheetName("Table1"), "comparetwosheets\\CTS_020_duplicatesMoveCustomLocation.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
