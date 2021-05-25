package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.Test;

import static googlesheets.model.mergesheets.ColumnDisplayEnumeration.UPDATE_VALUES_IN_ONLY;
import static googlesheets.model.mergesheets.MergeSheetsActionEnumeration.UPDATE_VALUES_IN;

public class MS029_updateValuesInOnlyTest extends MSTest {
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
                .columnDisplay(UPDATE_VALUES_IN_ONLY)
                .updatedColumns(new TripleSelection<>(1, UPDATE_VALUES_IN, "Pcs"))
                .addNonMatchingRows(true)
                .build();
        execute(options);
        checkResult();
    }
}
