package googlesheets.test.process.afr;

import googlesheets.model.process.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.process.advancedfindreplace.SearchInSelection;
import googlesheets.test.process.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;

public class AFR035_notesExportRowsWithAllFoundEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1tcTdudbspXcC3oJXr0R0yrcUvSg36kYOX7wL3affyts/edit#gid=125546058");
    }

    @Test
    public void notesExportRowsWithAllFoundEntries() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2)
                .searchString("Note")
                .notes(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.EXPORT_ROWS_WITH_ALL_ENTRIES);
        checkResult("Export results ");
    }
}
