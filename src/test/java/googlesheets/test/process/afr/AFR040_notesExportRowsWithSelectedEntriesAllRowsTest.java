package googlesheets.test.process.afr;

import googlesheets.model.process.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.process.advancedfindreplace.SearchInSelection;
import googlesheets.test.process.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;
import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.selectedEntries;

public class AFR040_notesExportRowsWithSelectedEntriesAllRowsTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/174IvEtyQNhnbF-KKFUgwxGC6fwHjUkNLDDCcjUoQr4k/edit#gid=125546058");
    }

    @Test
    public void notesExportRowsWithSelectedEntriesAllRows() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2,3)
                .searchString("note")
                .notes(true)
                .build();
        execute(options);

        selectedEntries("Master");
        runMenuAction(AFRActionEnumeration.EXPORT_ROWS_WITH_SELECTED_ENTRIES);
        checkResult("Export results ");
    }

}
