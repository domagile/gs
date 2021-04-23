package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

public class MS001_oneFieldNumberTest extends MSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1bPtGcXtK2uovPuiXBSOh6LIkrMW6Q1Zsp63dlbz5UfM/edit#gid=1599689917");
    }


    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("B2:D6")
                .lookupSheet("Lookup")
                .lookupTableRange("B2:E8")
                .mainTableHasHeaders(true)
                .lookupTableHasHeaders(true)
                .matchingColumns(new PairSelection<>(1, "ID"), new PairSelection<>(2, "Name"))
                .addNonMatchingRows(true)
                .build();
        execute(options);
        checkResult();
    }
}
