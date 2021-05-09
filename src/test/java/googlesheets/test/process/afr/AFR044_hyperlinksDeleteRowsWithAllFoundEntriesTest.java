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

public class AFR044_hyperlinksDeleteRowsWithAllFoundEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1N3DAbIjGLZ3Gyi-yO4rXtcxUQgP8i87VEZO0FxK9m5s/edit#gid=23700143");
    }

    @Test
    public void hyperlinksDeleteRowsWithAllFoundEntries() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2)
                .searchString("com")
                .hyperlinks(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.DELETE_ROWS_WITH_ALL_ENTRIES);
        checkResult("Master");
    }

    protected void restoreInitialDocumentState(String resultListName) {
        //fixme: restoration of data should be done through API
        //wait after CSV download start
        sleep(2000);
        clickUndo(5);
    }
}
