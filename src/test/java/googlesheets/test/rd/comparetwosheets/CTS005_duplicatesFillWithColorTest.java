package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.removeduplicates.comparetwosheets.ColumnComparisonPair;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS005_duplicatesFillWithColorTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1UHoKjcGtOWMd73h5ArzLzYM17yNDGm3ljRF1tRORxaw/edit#gid=1130625838");
    }

    @Ignore
    @Test
    public void duplicatesFillWithColor() throws IOException {
        runCompareColumnsOrSheets();
        setCreateBackupCopyOfSheet(false);
        setStep1Range("C4:I10");
        clickNext();

        setStep2Range("E8:I14");
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
        checkResult("Table1", "comparetwosheets\\CTS_005_duplicatesFillWithColor.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
