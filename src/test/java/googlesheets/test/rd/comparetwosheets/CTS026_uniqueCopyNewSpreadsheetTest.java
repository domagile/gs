package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import org.junit.Test;

import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS026_uniqueCopyNewSpreadsheetTest extends CTSTest {
    @Test
    public void uniqueCopyNewSpreadsheet() {
        runCompareColumnsOrSheets();
        setCreateBackupCopyOfSheet(false);
        setStep1Range("C3:I10");
        clickNext();

        setStep2Range("E7:K14");
        clickNext();

        clickUniqueValuesRadioButton();
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
        checkNewSpreadsheetResult("Table1", "comparetwosheets\\CTS_026 - uniqueCopyNewSpreadsheet.csv", resultInfo);

    }

}
