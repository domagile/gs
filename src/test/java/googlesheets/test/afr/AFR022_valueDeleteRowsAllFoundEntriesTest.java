package googlesheets.test.afr;

import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public class AFR022_valueDeleteRowsAllFoundEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/13yUtnkByYEMbiYlPUOwSTrOxUxR_AMfmnoFbRsA7KtQ/edit#gid=51550406");

    }

    @Test
    public void valueDeleteRowsAllFoundEntries() throws IOException {
        runAdvancedFindAndReplace();
        setSearchIn(SearchInSelection.SELECTED_LISTS, 2);

        setSearchString("600");
        setMatchCase(false);
        setEntireCell(false);
        setByMask(false);

        setValues(true);
        setFormulas(false);
        setNotes(false);
        setHyperlinks(false);
        setErrors(false);

        clickFindAll();

        runDeleteRowsWithAllFoundEntries();
        checkResult("Master", "advancedfindreplace\\AFR_022_valueDeleteRowsAllFoundEntries.csv");

    }


    protected void restoreInitialDocumentState(String resultListName) {
        //fixme: restoration of data should be done through API
        //wait after CSV download start
        sleep(2000);
        clickUndo(20);
    }
}
