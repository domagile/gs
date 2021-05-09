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
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class AFR042_notesDeleteRowsSelectedEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1xL-pDG6xrzxuMco4DgDsDChdkU-HkRSh_nw2fRP4jY8/edit#gid=1558039018");

    }


    @Test
    public void notesDeleteSelectedEntries() {

        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchSheetIndexes(2, 3)
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchString("note")
                .notes(true)
                .build();
        execute(options);
        selectedEntries("Master");
        runMenuAction(AFRActionEnumeration.DELETE_ROWS_WITH_SELECTED_ENTRIES);


        sleep(7000);
        checkResult("Master");

    }

    protected void restoreInitialDocumentState(String resultListName) {
        //fixme: restoration of data should be done through API
        //wait after CSV download start
        sleep(2000);
        clickUndo(30);
    }

}
