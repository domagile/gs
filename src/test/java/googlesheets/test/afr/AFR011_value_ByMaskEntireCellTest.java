package googlesheets.test.afr;

import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.service.generic.WebDriverService;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.time.Duration;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;

public class AFR011_value_ByMaskEntireCellTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1tbEWqGXAnvPx1iyewZI2tvNZsqvsTV-YuBYxtCOjbHU/edit#gid=199830560");
    }

    @Test
    public void valuesByMaskEntireCellAllSheets() throws IOException {
        runAdvancedFindAndReplace();
        setSearchIn(SearchInSelection.SELECTED_LISTS, 2,3);


        setSearchString("Ja* T*");
        setMatchCase(false);
        setEntireCell(true);
        setByMask(true);

        setValues(true);
        setFormulas(false);
        setNotes(false);
        setHyperlinks(false);
        setErrors(false);

        clickFindAll();

        //todo: replace with CustomTimeoutRule
        WebDriverService.getInstance().getWait().withTimeout(Duration.ofSeconds(60));
        try {
            runExportAllFoundEntries();
        }
        finally {
            WebDriverService.getInstance().resetWaitTimeout();
        }

        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_011_value_ByMask.csv");
    }
}
