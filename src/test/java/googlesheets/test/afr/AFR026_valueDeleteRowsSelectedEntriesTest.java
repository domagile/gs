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
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class AFR026_valueDeleteRowsSelectedEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1UX_FzYQYi3wNhjZOeXGg_zg1wn9BFQkowScfOxnGT88/edit#gid=1692402889");

    }


    @Test
    public void valueDeleteSelectedEntries() {

        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchSheetIndexes(2, 3)
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchString("MO")
                .values(true)
                .build();
        execute(options);
        selectedEntries("Master");
        runMenuAction(AFRActionEnumeration.DELETE_ROWS_WITH_SELECTED_ENTRIES, 120);


        sleep(7000);
        checkResult(getResultSheetName("Master"), "advancedfindreplace\\AFR_026_valueDeleteSelectedEntries.csv");

    }

    protected void restoreInitialDocumentState(String resultListName) {
        //fixme: restoration of data should be done through API
        //wait after CSV download start
        sleep(2000);
        clickUndo(30);
    }

}
