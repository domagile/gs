package googlesheets.test.afr;

import googlesheets.model.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public class AFR_valueDeleteRowsTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1Iklr2mmXFH4WhIW3xaHE-dMjDBXonf29lhRfj5VqS2w/edit#gid=1138814538");

    }

@Ignore
    @Test
    public void valueDeleteRowsAllFoundEntries() {

        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchSheetIndexes(2)
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchString("CA")
                .values(true)
                .build();
        execute(options);
        runMenuAction(AFRActionEnumeration.DELETE_ROWS_WITH_ALL_ENTRIES, 120);

        sleep(7000);
        checkResult("Master", "advancedfindreplace\\AFR_022_valueDeleteRowsAllFoundEntries.csv");

    }


    protected void restoreInitialDocumentState(String resultListName) {
        //fixme: restoration of data should be done through API
        //wait after CSV download start
        sleep(2000);
        clickUndo(20);
    }
}
