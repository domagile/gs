package googlesheets.test.afr;

import googlesheets.model.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class AFR030_FormulaExportTheSelectedEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/11E3rTYpNL3-LPZnM-OQOnnpndV3FuRf8wjXEe2g6xTo/edit#gid=2010638368");
    }

    @Test
    public void formulaExportTheSelectedEntriesOneRow() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2)
                .searchString("sum")
                .formulas(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.EXPORT_SELECTED_ENTRIES);
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_030_formulaExportTheSelectedEntriesOneRow.csv");
    }

}
