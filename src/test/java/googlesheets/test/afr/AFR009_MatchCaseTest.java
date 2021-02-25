package googlesheets.test.afr;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;

public class AFR009_MatchCaseTest extends AFRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1RSPvQnYajSiTI2bsq1--UOz8Isud0RKjav5EoYSgMic/edit#gid=811012383");
    }

    @Test
    public void valuesMatchCaseAllSheets() throws IOException, InterruptedException {
        runAdvancedFindAndReplace();
        setSearchIn(SearchInSelection.SELECTED_LISTS, 2,3);


        setSearchString("David");
        setMatchCase(true);
        setEntireCell(false);
        setByMask(false);

        setValues(true);
        setFormulas(false);
        setNotes(false);
        setHyperlinks(false);
        setErrors(false);

        clickFindAll();
        runExportAllFoundEntries();
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_009_MatchCaseTest.csv");
    }
}
