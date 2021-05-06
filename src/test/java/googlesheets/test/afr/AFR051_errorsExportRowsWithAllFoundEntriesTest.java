package googlesheets.test.afr;

import googlesheets.model.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;
import static googlesheets.service.generic.google.GoogleSheetService.getResultSheetName;

public class AFR051_errorsExportRowsWithAllFoundEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/18sxhZPArPT8A2rKxu45pNsE4m5n9cHXbHUCiMveT68o/edit#gid=343746373");
    }

    @Test
    public void errorsExportRowsWithAllFoundEntries() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2,3)
                .searchString("REF")
                .errors(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.EXPORT_ROWS_WITH_ALL_ENTRIES);
        checkResult(getResultSheetName("Export results "), "advancedfindreplace\\AFR_051_errorsExportRowsWithAllFoundEntries.csv");
    }
}
