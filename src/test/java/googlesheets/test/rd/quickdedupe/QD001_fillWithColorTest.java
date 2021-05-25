package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.*;


public class QD001_fillWithColorTest extends QDTest {
    @Test
    public void fillWithColor() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .range("B2:B40")
                .columnIndexes(1)
                .action(QuickDedupeActionEnumeration.FILL_WITH_COLOR)
                .build();
        execute(options);

        checkExcelResult(getFullSheetName("Master"), "quickdedupe\\QD_001_fillWithColor.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
