package googlesheets.test.afr;

import googlesheets.model.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;
import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.selectedEntries;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;

public class AFR032_FormulaExportRowsWithSelectedEntriesOneRowTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1eGu3eEBZReDy5M50ebIkWMaO_RoLuTO0eQwwpgccuDM/edit#gid=2010638368");
    }

    @Test
    public void formulaExportRowsWithSelectedEntriesOneRow() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2,3)
                .searchString("sum")
                .formulas(true)
                .build();
        execute(options);


        runMenuAction(AFRActionEnumeration.EXPORT_ROWS_WITH_SELECTED_ENTRIES);
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_032_formulaExportRowsWithSelectedEntriesOneRow.csv");
    }

}