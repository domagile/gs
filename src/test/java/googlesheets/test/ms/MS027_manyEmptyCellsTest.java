package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.mergesheets.MergeSheetsActionEnumeration.UPDATE_VALUES_IN;

public class MS027_manyEmptyCellsTest extends MSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/11o8XZwqQdmJjjsj_yHhXpbrW89hSUQ6alUgVnbwg16Y/edit#gid=931034343");
    }


    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("A2:D17")
                .lookupSheet("Lookup")
                .lookupTableRange("B2:E22")
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
