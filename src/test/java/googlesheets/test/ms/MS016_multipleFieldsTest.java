package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsActionEnumeration;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

public class MS016_multipleFieldsTest extends MSTest {
    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("A2:D17")
                .lookupSheet("Lookup")
                .lookupTableRange("C4:F24")
                .mainTableHasHeaders(true)
                .lookupTableHasHeaders(true)
                .matchingColumns(new PairSelection<>(1, "Articul"), new PairSelection<>(2, "Name"))
                .updatedColumns(new TripleSelection<>(3, MergeSheetsActionEnumeration.UPDATE_VALUES_IN, "Pcs"),
                        new TripleSelection<>(4, MergeSheetsActionEnumeration.UPDATE_VALUES_IN, "Price"))
                .addNonMatchingRows(true)
                .build();
        execute(options);
        checkResult();
    }
}
