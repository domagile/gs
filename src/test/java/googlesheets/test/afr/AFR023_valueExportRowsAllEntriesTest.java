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

public class AFR023_valueExportRowsAllEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1JwavDDyUL-dmpeVWoy0_u8aJMjPzh7yg0HZz_6_-3sI/edit#gid=864208606");

    }


    @Test
    public void valueExportRowsAllEntries() {

        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchSheetIndexes(2)
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchString("600")
                .values(true)
                .build();
        execute(options);
       runMenuAction(AFRActionEnumeration.EXPORT_ROWS_WITH_ALL_ENTRIES);


        sleep(7000);
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_023_valueExportRowsAllEntries.csv");

    }

}
