package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getFullSheetName;


public class QD006_copyNewSheetTest extends QDTest {
    @Test
    public void copyNewSheet() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .range("B2:B40")
                .columnIndexes(1)
                .action(QuickDedupeActionEnumeration.COPY_TO_A_NEW_SHEET)
                .build();
        execute(options);

        checkResult(getFullSheetName("Master - duplicates"), "quickdedupe\\QD_006_copyNewSheet.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(15);
    }
}
