package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.generic.addon.ResultInfo;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.waitForNewSpreadsheetAndClose;

public class CTS026_uniqueCopyNewSpreadsheetTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1YJx_DCwJOTdOLtOfd7ieyl_1JI55izsqPBZa9_Malzg/edit#gid=337615241");
    }

    @Test
    public void uniqueCopyNewSpreadsheet() throws IOException {
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

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        //todo: replace with some rollback through API
        clickUndo(10);
    }
}
