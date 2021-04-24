package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.mergesheets.MergeSheetsActionEnumeration.UPDATE_VALUES_IN;

public class MS026_symbolsTest extends MSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1YINNA2J6CGxP6txNha6gMxyS1UcREU0hcmVBbk2IuYo/edit#gid=1271394453");
    }


    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("A2:D17")
                .lookupSheet("Lookup")
                .lookupTableRange("A2:D22")
                .mainTableHasHeaders(true)
                .lookupTableHasHeaders(true)
                .matchingColumns(new PairSelection<>(1, "Articul"), new PairSelection<>(2, "Name"))
                .updatedColumns(new TripleSelection<>(3, UPDATE_VALUES_IN, "Pcs"),
                        new TripleSelection<>(4, UPDATE_VALUES_IN, "Price"))
                .addNonMatchingRows(true)
                .build();
        execute(options);
        checkResult();
    }
}
