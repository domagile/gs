package googlesheets.test.afr;

import googlesheets.model.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;

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
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_053_errorsExportTheSelectedEntriesOneRow.csv");
    }

}
