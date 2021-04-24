package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsActionEnumeration;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class MS005_nonMatchingRowsStatusColumnTest extends MSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1UgHkL4jhOIyD9Jn_EYw7yLqvEyyqzxNZ2Z4r2eTKSh8/edit#gid=1483068467");
    }


    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("C2:E6")
                .lookupSheet("Lookup")
                .lookupTableRange("C2:F12")
                .mainTableHasHeaders(true)
                .lookupTableHasHeaders(true)
                .matchingColumns(new PairSelection<>(1, "ID"))
                .updatedColumns(new TripleSelection<>(2, MergeSheetsActionEnumeration.UPDATE_VALUES_IN, "Name"),
                        new TripleSelection<>(3, MergeSheetsActionEnumeration.UPDATE_VALUES_IN, "Address"),
                        new TripleSelection<>(4, MergeSheetsActionEnumeration.ADD_TO_END, null))
                .addNonMatchingRows(true)
                .addStatusColumn(true)
                .build();
        execute(options);
        checkResult();
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(3);
    }
}
