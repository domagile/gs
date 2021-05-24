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

public class MS018_columnAdditionTest extends MSTest {
    @Test
    public void merge()
    {
        MergeSheetsOptions options = new MergeSheetsOptionBuilder()
                .mainSheet("Master")
                .mainTableRange("A2:C17")
                .lookupSheet("Lookup")
                .lookupTableRange("C4:H24")
                .mainTableHasHeaders(true)
                .lookupTableHasHeaders(true)
                .matchingColumns(new PairSelection<>(1, "Articul"), new PairSelection<>(2, "Name"))
                .updatedColumns(new TripleSelection<>(4, MergeSheetsActionEnumeration.ADD_TO_END, null),
                        new TripleSelection<>(5, MergeSheetsActionEnumeration.ADD_TO_END, null),
                        new TripleSelection<>(6, MergeSheetsActionEnumeration.ADD_TO_END, null))
                .addNonMatchingRows(true)
                .build();
        execute(options);
        checkResult();
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(2);
    }
}
