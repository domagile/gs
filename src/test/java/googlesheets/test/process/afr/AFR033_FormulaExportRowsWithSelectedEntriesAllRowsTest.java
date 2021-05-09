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

public class AFR033_FormulaExportRowsWithSelectedEntriesAllRowsTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1HgUT7lyfPkxKAsgR5GmuDSluDPpreUAkXns19PgFgaU/edit#gid=2010638368");
    }

    @Test
    public void formulaExportRowsWithSelectedEntriesAllRows() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2,3)
                .searchString("sum")
                .formulas(true)
                .build();
        execute(options);

        selectedEntries("Master");
        runMenuAction(AFRActionEnumeration.EXPORT_ROWS_WITH_SELECTED_ENTRIES);
        checkResult("Export results ");
    }

}
