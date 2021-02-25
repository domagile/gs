package googlesheets.test.afr;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.clickUndo;
import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;

public class AFR021_valueExportRowsAllEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1SE-dQAl2bDVBvGd_7LJsRwxmhToRSELDKFkKoA9HlOg/edit#gid=21154533");
    }

    @Ignore
    @Test
    public void valuesExportRowsAllEntries() throws IOException, InterruptedException {
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

// не дописан
   
}
