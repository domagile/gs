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

public class AFR050_hyperlinksDeleteRowsWithSelectedEntriesAllRowsTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/15RxLrn6fkydO3yltfhEAKEJN8fvetHgvkbxPJtI6iTM/edit#gid=23700143");
    }

    @Test
    public void hyperlinksDeteleRowsWithSelectedEntriesAllRows() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2, 3)
                .searchString("com")
                .hyperlinks(true)
                .build();
        execute(options);

        selectedEntries("Master");
        runMenuAction(AFRActionEnumeration.DELETE_ROWS_WITH_SELECTED_ENTRIES);

        sleep(7000);
        checkResult(getResultListName("Master"), "advancedfindreplace\\AFR_050_hyperlinksDeleteRowsWithSelectedEntriesAllRows.csv");
    }

    protected void restoreInitialDocumentState(String resultListName) {
        //fixme: restoration of data should be done through API
        //wait after CSV download start
        sleep(2000);
        clickUndo(5);
    }

}
