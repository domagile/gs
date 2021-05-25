package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class QD012_clearValuesAllColumnsTest extends QDTest {
    @Test
    public void clearValuesAllColumns() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .range("A1:E34")
                .columnIndexes(1, 2, 3, 4, 5)
                .action(QuickDedupeActionEnumeration.CLEAR_VALUES)
                .build();
        execute(options);

        checkResult("Master", "quickdedupe\\QD_012_clearValuesAllColumns.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(15);
    }
}
