package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;


public class QD015_moveNewSheetAllColumnsBackupTest extends QDTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1H3Eha0TgsefEKdiw666L7tCg7QTHqOdPGHyo5YAezCM/edit#gid=631658331");
    }

    @Test
    public void moveNewSheetAllColumnsBackup() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .range("A1:E71")
                .columnIndexes(1, 2, 3, 4, 5)
                .action(QuickDedupeActionEnumeration.MOVE_TO_A_NEW_SHEET)
                .createSheetBackupCopy(true)
                .build();
        execute(options);

        checkResult(getResultListName("Master - duplicates"), "quickdedupe\\QD_015_moveNewSheetAllColumnsBackup.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(15);
    }
}
