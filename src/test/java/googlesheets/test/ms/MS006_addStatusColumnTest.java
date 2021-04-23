package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsActionEnumeration;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class MS006_addStatusColumnTest extends MSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/12WV6IfyZE2w9KcYeKa2Ve1e-W4qLi09Hufs-WT3A4Wg/edit#gid=1447556732");
    }


    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("A2:C6")
                .lookupSheet("Lookup")
                .lookupTableRange("A2:D13")
                .mainTableHasHeaders(true)
                .lookupTableHasHeaders(true)
                .matchingColumns(new PairSelection<>(1, "ID"))
                .updatedColumns(new TripleSelection<>(2, MergeSheetsActionEnumeration.UPDATE_VALUES_IN, "Name"),
                        new TripleSelection<>(3, MergeSheetsActionEnumeration.UPDATE_VALUES_IN, "Address"),
                        new TripleSelection<>(4, MergeSheetsActionEnumeration.ADD_TO_END, null))
                .addStatusColumn(true)
                .build();
        execute(options);
        checkResult();
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(2);
    }
}
