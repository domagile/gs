package googlesheets.test.process.afr;

import googlesheets.model.process.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.process.advancedfindreplace.SearchInSelection;
import googlesheets.test.process.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class AFR023_valueEntireCellExportSelectedEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1JwavDDyUL-dmpeVWoy0_u8aJMjPzh7yg0HZz_6_-3sI/edit#gid=864208606");

    }


    @Test
    public void valueEntireCellExportSelectedEntries() {

        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchSheetIndexes(2)
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchString("MO")
                .entireCell(true)
                .values(true)
                .build();
        execute(options);
       runMenuAction(AFRActionEnumeration.EXPORT_SELECTED_ENTRIES);


        sleep(7000);
        checkResult("Export results ");

    }

}
