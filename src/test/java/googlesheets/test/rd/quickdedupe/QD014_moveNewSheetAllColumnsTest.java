package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getFullSheetName;


public class QD014_moveNewSheetAllColumnsTest extends QDTest {
    @Test
    public void moveNewSheetAllColumns() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .range("A1:E34")
                .columnIndexes(1, 2, 3, 4, 5)
                .action(QuickDedupeActionEnumeration.MOVE_TO_A_NEW_SHEET)
                .build();
        execute(options);

        checkResult(getFullSheetName("Master - duplicates"), "quickdedupe\\QD_014_moveNewSheetAllColumns.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(15);
    }
}
