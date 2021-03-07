package googlesheets.test.afr;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;

public class AFR006_ErrorTest extends AFRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1A0MsAAykZQjUZh_2Ivyt7nh3PHh-Ek-ac8lgrpgwP68/edit#gid=343746373");
    }

    @Test
    public void formula() throws IOException, InterruptedException {
        runAdvancedFindAndReplace();
        setSearchIn(SearchInSelection.SELECTED_LISTS, 2);

        setSearchString("*");
        setMatchCase(false);
        setEntireCell(false);
        setByMask(true);

        setValues(false);
        setFormulas(false);
        setNotes(false);
        setHyperlinks(false);
        setErrors(true);

        clickFindAll();
        runExportAllFoundEntries();
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_006_Errors.csv");
    }
}
