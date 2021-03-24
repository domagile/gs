package googlesheets.test.afr;

import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;

public class AFR021_valueExportRowsAllEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1SE-dQAl2bDVBvGd_7LJsRwxmhToRSELDKFkKoA9HlOg/edit#gid=21154533");
    }

    @Test
    public void valuesExportRowsAllEntries() throws IOException {
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

        runExportRowsWithAllFoundEntries();
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_021_valueExportRowsAllEntries.csv");
    }


   
}
