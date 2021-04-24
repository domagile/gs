package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.mergesheets.MergeSheetsActionEnumeration.ADD_TO_END;
import static googlesheets.model.mergesheets.MergeSheetsActionEnumeration.UPDATE_VALUES_IN;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class MS021_clearBackgroundTest extends MSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1nP-6RcFIMHDww_AfmHZq4-IzeTbv6FpwDms8LC32nAY/edit#gid=845270708");
    }


    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("B2:C5")
                .lookupSheet("Lookup")
                .lookupTableRange("B2:C6")
                .mainTableHasHeaders(true)
                .lookupTableHasHeaders(true)
                .matchingColumns(new PairSelection<>(1, "Fruit"))
                .updatedColumns(new TripleSelection<>(2, UPDATE_VALUES_IN, "Price"))
                .clearBackground(true)
                .build();
        execute(options);
        checkExcelResult();
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(2);
    }
}
