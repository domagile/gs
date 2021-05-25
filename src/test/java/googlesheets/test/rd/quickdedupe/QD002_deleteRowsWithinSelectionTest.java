package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class QD002_deleteRowsWithinSelectionTest extends QDTest {
    @Test
    public void deleteRowsWithinSelection() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .columnIndexes(1)
                .action(QuickDedupeActionEnumeration.DELETE_ROWS_WITHIN_SELECTION)
                .tableHasHeaders(true)
                .build();
        execute(options);

        checkResult("Master", "quickdedupe\\QD_002_deleteRowsWithinSelection.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
