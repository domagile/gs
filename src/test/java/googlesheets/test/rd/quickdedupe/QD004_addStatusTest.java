package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class QD004_addStatusTest extends QDTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1cdTk81mCDzew2iPB9oHeyrUm7YxSOsoou_qqc-p95Qw/edit#gid=1900589725");
    }

    @Test
    public void addStatus() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .range("B4:B42")
                .columnIndexes(1)
                .action(QuickDedupeActionEnumeration.ADD_STATUS_COLUMN)
                .build();
        execute(options);

        checkResult("Master", "quickdedupe\\QD_004_addStatus.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
