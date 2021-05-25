package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class QD010_deleteEntireRowsOnTheSheetAllColumnsTest extends QDTest {
    @Test
    public void deleteEntireRowsOnTheSheetAllColumns() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .range("A1:E24")
                .columnIndexes(1, 2, 3, 4, 5)
                .action(QuickDedupeActionEnumeration.DELETE_ENTIRE_ROWS_ON_THE_SHEET)
                .skipEmptyCells(true)
                .tableHasHeaders(true)
                .build();
        execute(options);

        checkResult("Master", "quickdedupe\\QD_010_deleteEntireRowsOnTheSheetAllColumns.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(15);
    }
}
