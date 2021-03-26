package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.removeduplicates.comparetwosheets.ColumnComparisonPair;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS012_duplicatesFillWithColorTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1bCiZZlF0XCWVFfhe70FRlStjKiyPQ988VUlzrYZ_iF8/edit#gid=1066115301");

    }

    @Test
    public void duplicatesFillWithColor() throws IOException {
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

        clickFillWithColor();
        clickFinishAndClose();
        checkExcelResult("Table1", "comparetwosheets\\CTS_012_duplicatesFillWithColor.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
