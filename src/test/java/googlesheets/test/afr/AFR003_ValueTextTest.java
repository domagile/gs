package googlesheets.test.afr;

import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;

public class AFR003_ValueTextTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1hVrBsl92v4XSQSVSCS6lH0_g-ie_lWho2NjbNGFgyP8/edit#gid=2017121442");
    }

    @Test
    public void valuesTextAllSheets() throws IOException {
        runAdvancedFindAndReplace();
        setSearchIn(SearchInSelection.SELECTED_LISTS, 2, 3);


        setSearchString("David");
        setMatchCase(false);
        setEntireCell(false);
        setByMask(false);

        setValues(true);
        setFormulas(false);
        setNotes(false);
        setHyperlinks(false);
        setErrors(false);

        clickFindAll();
        runExportAllFoundEntries();

        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_003_valueTextAllSheets.csv");
    }
}
