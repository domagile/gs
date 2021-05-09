package googlesheets.test.process.afr;

import googlesheets.model.process.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.process.advancedfindreplace.SearchInSelection;
import googlesheets.test.process.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;

public class AFR053_errorsExportTheSelectedEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/10r7WnIDRgDRr8NcQ3noWFUFwr5aAsXCNY_aZWUFJy7M/edit#gid=343746373");
    }

    @Test
    public void errorsExportTheSelectedEntriesOneRow() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2)
                .searchString("ref")
                .errors(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.EXPORT_SELECTED_ENTRIES);
        checkResult("Export results ");
    }

}
