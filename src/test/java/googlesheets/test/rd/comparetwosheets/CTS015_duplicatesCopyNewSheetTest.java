package googlesheets.test.rd.comparetwosheets;

import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.getFullSheetName;
import static googlesheets.service.generic.google.GoogleSheetService.removeSheetThroughMenu;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS015_duplicatesCopyNewSheetTest extends CTSTest {
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
         checkResult(getFullSheetName("Table1 - duplicates"), "comparetwosheets\\CTS_015_duplicatesCopyNewSheet.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        removeSheetThroughMenu(resultListName);
    }
}
