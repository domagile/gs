package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.GoogleSheetService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.*;
import static googlesheets.service.comparetwosheets.CompareTwoSheetsService.*;

public class CTS017_duplicatesCopyExistingSheetTest extends CTSTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1Y1sDf_HUxcFSL6fFjCnsNzMscKEVMqsmkgN-f0JTdrA/edit#gid=117501248");
    }

    @Test
    public void duplicatesCopyToExistingSheet() throws IOException, InterruptedException {
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

        clickCopyToAnotherLocation();
        clickExistingSheet();
        selectExistingSheet("Table1");
        //wait for Table1 list to become active
        Thread.sleep(1000);
        setRangeExistingSheet("K1");

        clickFinishAndClose();
        checkResult(getResultListName("Table1"), "comparetwosheets\\CTS_017_duplicatesCopyToExistingSheet.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) throws InterruptedException {
        clickUndo(5);
    }
}
