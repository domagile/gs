package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.GoogleSheetService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS020_duplicatesMoveExistingSheetTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1Fpo8Dojm3E-IQKNUrpxTD6ZkqQW3dPzrk6Axit1Bois/edit#gid=315044403");
    }

    @Test
    public void duplicatesMoveToExistingSheet() throws IOException {
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
        clickExistingSheet();
        selectExistingSheet("Table1");
        //wait for Table1 list to become active
        sleep(1000);
        setRangeExistingSheet("K1");

        clickFinishAndClose();
        checkResult(getResultListName("Table1"), "comparetwosheets\\CTS_020_duplicatesMoveToExistingSheet.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
