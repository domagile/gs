package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.Test;

import static googlesheets.model.mergesheets.MergeSheetsActionEnumeration.UPDATE_VALUES_IN;

public class MS023_withoutHeadersTest extends MSTest {
    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("A2:D16")
                .lookupSheet("Lookup")
                .lookupTableRange("B2:E21")
                .matchingColumns(new PairSelection<>(1, "Column B"), new PairSelection<>(2, "Column C"))
                .updatedColumns(new TripleSelection<>(3, UPDATE_VALUES_IN, "Column C"),
                        new TripleSelection<>(4, UPDATE_VALUES_IN, "Column D"))
                .addNonMatchingRows(true)
                .build();
        execute(options);
        checkResult();
    }
}
