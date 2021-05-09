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

public class AFR046_hyperlinksExportTheSelectedEntriesAllRowsTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1U9aOvVS0z6KVRMudEKSN779Q1Vt9sPa9ctYxVKIa3hU/edit#gid=23700143");
    }

    @Test
    public void hyperlinksExportTheSelectedEntriesAllRows() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2,3)
                .searchString("com")
                .hyperlinks(true)
                .build();
        execute(options);

        selectedEntries("Master");
        runMenuAction(AFRActionEnumeration.EXPORT_SELECTED_ENTRIES);
        checkResult("Export results ");
    }

}
