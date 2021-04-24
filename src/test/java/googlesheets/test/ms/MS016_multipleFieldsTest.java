package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsActionEnumeration;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

public class MS016_multipleFieldsTest extends MSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/16s5augUIAsILyKX_KM_INHrmO5EdsT2M-TFiBpSxtw0/edit#gid=606762906");
    }


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
