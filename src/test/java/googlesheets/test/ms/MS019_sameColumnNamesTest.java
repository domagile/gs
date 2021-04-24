package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsActionEnumeration;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.mergesheets.MergeSheetsActionEnumeration.UPDATE_VALUES_IN;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class MS019_sameColumnNamesTest extends MSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1WrgOzBr5Fk5-uxk52MZUNRmU-io_0JL7Odd_9uWvMwM/edit#gid=1799660894");
    }


    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("A2:E17")
                .lookupSheet("Lookup")
                .lookupTableRange("C4:G24")
                .mainTableHasHeaders(true)
                .lookupTableHasHeaders(true)
                .matchingColumns(new PairSelection<>(1, "Articul"), new PairSelection<>(2, "Name"))
                .updatedColumns(new TripleSelection<>(3, UPDATE_VALUES_IN, "Pcs"),
                        new TripleSelection<>(4, UPDATE_VALUES_IN, "(2) Price"),
                        new TripleSelection<>(5, UPDATE_VALUES_IN, "(1) Price"))
                .build();
        execute(options);
        checkResult();
    }
}
