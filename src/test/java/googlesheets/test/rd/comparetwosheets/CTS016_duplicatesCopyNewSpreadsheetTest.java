package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import org.junit.Test;

import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS016_duplicatesCopyNewSpreadsheetTest extends CTSTest {
    @Test
    public void duplicatesCopyNewSpreadsheet() {
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
        clickNewSpreadsheet();
        clickFinish();

        ResultInfo resultInfo = waitForNewSpreadsheetAndClose();
        checkNewSpreadsheetResult("Table1", "comparetwosheets\\CTS_016 - duplicatesCopyNewSpreadsheet.csv", resultInfo);

    }
}
