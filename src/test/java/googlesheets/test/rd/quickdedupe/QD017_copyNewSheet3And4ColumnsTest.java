package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultSheetName;


public class QD017_copyNewSheet3And4ColumnsTest extends QDTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1fSQ6P9n62pDxTJyzgGjy87pGeGr5voAkuVLeuidy-FM/edit#gid=631658331");
    }

    @Test
    public void copyNewSheetAllColumns() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .range("A1:E49")
                .columnIndexes(1, 2, 3, 4, 5)
                .action(QuickDedupeActionEnumeration.COPY_TO_A_NEW_SHEET)
                .skipEmptyCells(true)
                .tableHasHeaders(true)
                .createSheetBackupCopy(true)
                .build();
        execute(options);

        checkResult(getResultSheetName("Master - duplicates"), "quickdedupe\\QD_017_copyNewSheet3And4Columns.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(15);
    }
}
