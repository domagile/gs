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

public class MS028_allColumnsTest extends MSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1LiRGh6_EMzCuTIjvFxoaynZipHYjvuvLNYUFo2bK5oE/edit#gid=199511990");
    }


    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("B2:D12")
                .lookupSheet("Lookup")
                .lookupTableRange("B4:E24")
                .mainTableHasHeaders(true)
                .lookupTableHasHeaders(true)
                .matchingColumns(new PairSelection<>(1, "Articul"), new PairSelection<>(2, "Name"))
                .updatedColumns(new TripleSelection<>(3, UPDATE_VALUES_IN, "Pcs"),
                        new TripleSelection<>(4, ADD_TO_END, null))
                .addNonMatchingRows(true)
                .build();
        execute(options);
        checkResult();
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(2);
    }
}
