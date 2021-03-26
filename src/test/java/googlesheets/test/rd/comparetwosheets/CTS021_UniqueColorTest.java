package googlesheets.test.rd.comparetwosheets;

import googlesheets.service.removeduplicates.comparetwosheets.ColumnComparisonPair;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.comparetwosheets.CompareTwoSheetsService.*;

public class CTS021_UniqueColorTest extends CTSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1srwsTJ3Xabw-668NuZ37DuwS4KoUDIJwSInO2SXrtdA/edit#gid=160755906");

    }

    @Test
    public void uniqueFillWithColor() throws IOException {
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

        clickFillWithColor();
        clickFinishAndClose();
        checkExcelResult("Table1", "comparetwosheets\\CTS_021_uniqueFillWithColor.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
