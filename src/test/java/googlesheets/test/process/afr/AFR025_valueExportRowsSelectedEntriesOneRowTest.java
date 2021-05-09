package googlesheets.test.process.afr;

import googlesheets.model.process.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.process.advancedfindreplace.SearchInSelection;
import googlesheets.test.process.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;
import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public class AFR025_valueExportRowsSelectedEntriesOneRowTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1MCJ9W4a3PoLNKwONa-gng7Sml0ZCMJAqqMyv5kJ2Hu4/edit#gid=1692402889");

    }


    @Test
    public void valueExportSelectedEntriesOneRow() {

        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchSheetIndexes(2, 3)
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchString("MO")
                .values(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.EXPORT_ROWS_WITH_SELECTED_ENTRIES);

        sleep(5000);
        checkResult("Export results ");

    }

}
