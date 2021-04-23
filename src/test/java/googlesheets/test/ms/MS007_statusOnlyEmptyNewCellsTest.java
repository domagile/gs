package googlesheets.test.ms;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.MergeSheetsActionEnumeration;
import googlesheets.model.mergesheets.MergeSheetsOptionBuilder;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import googlesheets.service.generic.google.GoogleSheetService;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public class MS007_statusOnlyEmptyNewCellsTest extends MSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1Cp5ndKvJFwPyqv-vqufBYZoGrRHjRE4Eq20eylfVFHg/edit#gid=304723309");
    }


    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("B1:D5")
                .lookupSheet("Lookup")
                .lookupTableRange("B1:E12")
                .mainTableHasHeaders(true)
                .lookupTableHasHeaders(true)
                .matchingColumns(new PairSelection<>(1, "ID"))
                .updatedColumns(new TripleSelection<>(2, MergeSheetsActionEnumeration.UPDATE_VALUES_IN, "Name"),
                        new TripleSelection<>(3, MergeSheetsActionEnumeration.UPDATE_VALUES_IN, "Address"),
                        new TripleSelection<>(4, MergeSheetsActionEnumeration.ADD_TO_END, null))
                .addStatusColumn(true)
                .updateOnlyEmptyNewCells(true)
                .build();
        execute(options);
        checkResult();
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(3);
    }
}
