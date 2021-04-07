package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;


public class QD002_deleteRowsWithinSelectionTest extends QDTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1Ik9u8G6ZbBs2dXNw3Fw3ia_eG5lUZOKNuoeHNDizO3k/edit#gid=2044346499");
    }

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
