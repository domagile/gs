package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getFullSheetName;


public class QD007_moveNewSheetTest extends QDTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1v9xt2ZD6V2h4FN7ud1Ne1gjwnDK1-SIot1Q93bSn05A/edit#gid=1900589725");
    }

    @Test
    public void moveNewSheet() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .range("B2:B40")
                .columnIndexes(1)
                .action(QuickDedupeActionEnumeration.MOVE_TO_A_NEW_SHEET)
                .build();
        execute(options);

        checkResult(getFullSheetName("Master - duplicates"), "quickdedupe\\QD_007_moveNewSheet.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(15);
    }
}
