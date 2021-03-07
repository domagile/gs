package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.GoogleSheetService;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.*;
import static googlesheets.service.comparetwosheets.CompareTwoSheetsService.*;

public class CTS015_duplicatesCopyNewSheetTest extends CTSTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1pmKYiUTAvnhbgot1AJKCnV5obtxrvsSx6TdDChu0UCQ/edit#gid=1140838692");
    }

    @Test
    public void duplicatesCopyNewSheet() throws IOException, InterruptedException {
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
        clickNewSheet();

        clickFinishAndClose();
         checkResult(getResultListName("Table1 - duplicates"), "comparetwosheets\\CTS_015_duplicatesCopyNewSheet.csv");;
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) throws InterruptedException {
        removeListThroughMenu(resultListName);
    }
}
