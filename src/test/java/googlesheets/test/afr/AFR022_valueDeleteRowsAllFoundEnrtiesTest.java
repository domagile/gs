package googlesheets.test.afr;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;

public class AFR022_valueDeleteRowsAllFoundEnrtiesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1SE-dQAl2bDVBvGd_7LJsRwxmhToRSELDKFkKoA9HlOg/edit#gid=21154533");
    }

    @Test
    public void valueDeleteRowsAllFoundEnrties() throws IOException, InterruptedException {
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
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_022_valueDeleteRowsAllFoundEnrties.csv");
    }


   
}
