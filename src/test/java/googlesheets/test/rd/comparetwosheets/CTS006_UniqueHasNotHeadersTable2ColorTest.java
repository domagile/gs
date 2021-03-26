package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.removeduplicates.comparetwosheets.ColumnComparisonPair;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS006_UniqueHasNotHeadersTable2ColorTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1waghZUsmn2HfkJQQIDAqFl56d0jZ_daTpiEvcnb2EkA/edit#gid=691209808");

    }

    @Test
    public void uniqueFillWithColor() throws IOException {
        runCompareColumnsOrSheets();
        setCreateBackupCopyOfSheet(false);
        setStep1Range("C3:I10");
        clickNext();

        setStep2Range("E8:K14");
        clickNext();

        clickUniqueValuesRadioButton();
        clickNext();

        setTable1HasHeaders(true);
        setTable2HasHeaders(false);
        setSkipEmptyCells(false);
        setMatchCase(false);
        setColumnsToCompare(new ColumnComparisonPair(1, "Column E"),
                new ColumnComparisonPair(2, "Column F"),
                new ColumnComparisonPair(3, "Column G"));
        //clickAutoDetect();
        clickNext();

        clickFillWithColor();
        clickFinishAndClose();
        checkExcelResult("Table1", "comparetwosheets\\CTS_006_uniqueFillWithColor.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
