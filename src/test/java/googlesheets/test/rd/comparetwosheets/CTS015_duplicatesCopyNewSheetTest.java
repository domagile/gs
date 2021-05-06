package googlesheets.test.rd.comparetwosheets;

import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.getResultSheetName;
import static googlesheets.service.generic.google.GoogleSheetService.removeSheetThroughMenu;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS015_duplicatesCopyNewSheetTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1pmKYiUTAvnhbgot1AJKCnV5obtxrvsSx6TdDChu0UCQ/edit#gid=1140838692");
    }

    @Test
    public void duplicatesCopyNewSheet() {
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
         checkResult(getResultSheetName("Table1 - duplicates"), "comparetwosheets\\CTS_015_duplicatesCopyNewSheet.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        removeSheetThroughMenu(resultListName);
    }
}
