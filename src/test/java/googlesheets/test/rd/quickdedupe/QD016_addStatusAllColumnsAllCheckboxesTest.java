package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getFullSheetName;


public class QD016_addStatusAllColumnsAllCheckboxesTest extends QDTest {
    @Test
    public void addStatusAllColumnsAllCheckboxes() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .range("A1:E71")
                .columnIndexes(1, 2, 3, 4, 5)
                .action(QuickDedupeActionEnumeration.ADD_STATUS_COLUMN)
                .createSheetBackupCopy(true)
                .skipEmptyCells(true)
                .tableHasHeaders(true)
                .build();
        execute(options);

        checkResult(getFullSheetName("Master"), "quickdedupe\\QD_016_addStatusAllColumnsAllCheckboxes.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(15);
    }
}
