package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.mergesheets.MergeSheetsActionEnumeration.UPDATE_VALUES_IN;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class MS022_allRowColumnOptionsTest extends MSTest {
    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("B2:C5")
                .lookupSheet("Lookup")
                .lookupTableRange("B2:C6")
                .mainTableHasHeaders(true)
                .lookupTableHasHeaders(true)
                .matchingColumns(new PairSelection<>(1, "Fruit"))
                .updatedColumns(new TripleSelection<>(2, UPDATE_VALUES_IN, "Price"))
                .addNonMatchingRows(true)
                .addStatusColumn(true)
                .updateOnlyEmptyNewCells(true)
                .updateOnlyIfCellsFromLookupContainData(true)
                .clearBackground(true)
                .colorUpdatedCells(true)
                .build();
        execute(options);
        checkExcelResult();
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(7);
    }
}
