package googlesheets.test.process.afr;

import googlesheets.model.process.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.process.advancedfindreplace.SearchInSelection;
import googlesheets.test.process.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;

public class AFR055_errorsExportRowsWithSelectedEntriesOneRowTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1MmFF__jUunqaxrbfwzfzbkjdY8kkFfrvoUiJxR3vdFo/edit#gid=343746373");
    }

    @Test
    public void hyperlinksExportRowsWithSelectedEntriesOneRow() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2,3)
                .searchString("name")
                .errors(true)
                .build();
        execute(options);


        runMenuAction(AFRActionEnumeration.EXPORT_ROWS_WITH_SELECTED_ENTRIES);
        checkResult("Export results ");
    }

}
