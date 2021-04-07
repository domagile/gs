package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class QD003_deleteEntireRowsOnTheSheetTest extends QDTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1njY-BYe2ToBTzzQh3aAWTgWgH1FExk-pFxh5mLWfHjg/edit#gid=1900589725");
    }

    @Test
    public void deleteEntireRowsOnTheSheetAnsSkipEmptyCells() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .range("B4:B42")
                .columnIndexes(1)
                .action(QuickDedupeActionEnumeration.DELETE_ENTIRE_ROWS_ON_THE_SHEET)
                .skipEmptyCells(true)
                .build();
        execute(options);

        checkResult("Master", "quickdedupe\\QD_003_deleteEntireRowsOnTheSheetAnsSkipEmptyCells.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(15);
    }
}
