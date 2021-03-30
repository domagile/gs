package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.generic.addon.ResultInfo;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.waitForNewSpreadsheetAndClose;

public class CTS016_duplicatesCopyNewSpreadsheetTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1jNKu_cPPtrJSZEjWp199Zty1c9l7V8WGz08rOCvulUs/edit#gid=794119016");
    }

    @Test
    public void duplicatesCopyNewSpreadsheet() throws IOException {
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
