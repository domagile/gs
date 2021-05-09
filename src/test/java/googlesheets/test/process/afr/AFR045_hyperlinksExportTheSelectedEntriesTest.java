package googlesheets.test.process.afr;

import googlesheets.model.process.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.process.advancedfindreplace.SearchInSelection;
import googlesheets.test.process.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;

public class AFR045_hyperlinksExportTheSelectedEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/15RQAspsTyA8QQc2P8PrFpSuN9peuWoAe566_hbAks-k/edit#gid=23700143");
    }

    @Test
    public void hyperlinksExportTheSelectedEntriesOneRow() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2)
                .searchString("com")
                .hyperlinks(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.EXPORT_SELECTED_ENTRIES);
        checkResult("Export results ");
    }

}
