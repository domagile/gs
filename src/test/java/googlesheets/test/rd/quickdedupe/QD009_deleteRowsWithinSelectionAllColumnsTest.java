package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class QD009_deleteRowsWithinSelectionAllColumnsTest extends QDTest {
    @Test
    public void deleteRowsWithinSelectionAllColumn() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .range("A1:E24")
                .columnIndexes(1, 2, 3, 4, 5)
                .action(QuickDedupeActionEnumeration.DELETE_ROWS_WITHIN_SELECTION)
                .tableHasHeaders(true)
                .build();
        execute(options);

        checkResult("Master", "quickdedupe\\QD_009_deleteRowsWithinSelectionAllColumns.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
