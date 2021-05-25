package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class QD005_clearValuesTest extends QDTest {
    @Test
    public void clearValues() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .range("B2:B40")
                .columnIndexes(1)
                .action(QuickDedupeActionEnumeration.CLEAR_VALUES)
                .build();
        execute(options);

        checkResult("Master", "quickdedupe\\QD_005_clearValues.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(15);
    }
}
