package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsActionEnumeration;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class MS011_updateOnlyIfCellsContainDataTest extends MSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1UnEl4kGJevKl6ZCCefSyCclulUlCp5QSuUJkwn_R3B4/edit#gid=2038065021");
    }


    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("B2:D6")
                .lookupSheet("Lookup")
                .lookupTableRange("B2:E9")
                .mainTableHasHeaders(true)
                .lookupTableHasHeaders(true)
                .matchingColumns(new PairSelection<>(1, "ID"))
                .updatedColumns(new TripleSelection<>(2, MergeSheetsActionEnumeration.UPDATE_VALUES_IN, "Name"),
                        new TripleSelection<>(3, MergeSheetsActionEnumeration.UPDATE_VALUES_IN, "Address"),
                        new TripleSelection<>(4, MergeSheetsActionEnumeration.ADD_TO_END, null))
                .updateOnlyIfCellsFromLookupContainData(true)
                .build();
        execute(options);
        checkResult();
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(2);
    }
}