package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.removeduplicates.comparetwosheets.ColumnComparisonPair;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS005_duplicatesHasNotHeadersTable1ColorTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1og3FqLI14oudQaqsTYWuJ2TZI1t9RdBbJisE3NpQ2sk/edit#gid=544625530");

    }

    @Test
    public void duplicatesHasNotHeadersTable1FillWithColor() throws IOException {
        runCompareColumnsOrSheets();
        setCreateBackupCopyOfSheet(false);
        setStep1Range("C4:I10");
        clickNext();

        setStep2Range("E7:I14");
        clickNext();

        clickDuplicateValuesRadioButton();
        clickNext();

        setTable1HasHeaders(false);
        setTable2HasHeaders(true);
        setSkipEmptyCells(false);
        setMatchCase(false);
        setColumnsToCompare(new ColumnComparisonPair(1, "ID"),
                new ColumnComparisonPair(2, "Fruit"),
                new ColumnComparisonPair(3, "Caloric value"));
        //clickAutoDetect();
        clickNext();

        clickFillWithColor();
        clickFinishAndClose();
        checkExcelResult("Table1", "comparetwosheets\\CTS_005_duplicatesFillWithColor.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
