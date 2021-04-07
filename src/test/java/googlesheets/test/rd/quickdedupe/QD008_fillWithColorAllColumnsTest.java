package googlesheets.test.rd.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptionBuilder;
import googlesheets.model.rd.quickdedupe.QuickDedupeOptions;
import googlesheets.test.rd.quickdedupe.generic.QDTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;


public class QD008_fillWithColorAllColumnsTest extends QDTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/19JhwwaTC_OtgSniTAiHp4X8dEhvO1Q-9qY5DgzFp8WY/edit#gid=631658331");
    }

    @Test
    public void fillWithColorAllColumns() {
        QuickDedupeOptions options = new QuickDedupeOptionBuilder()
                .columnIndexes(1, 2, 3, 4, 5)
                .tableHasHeaders(true)
                .action(QuickDedupeActionEnumeration.FILL_WITH_COLOR)
                .build();
        execute(options);

        checkExcelResult(getResultListName("Master"), "quickdedupe\\QD_008_fillWithColorAllColumns.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
