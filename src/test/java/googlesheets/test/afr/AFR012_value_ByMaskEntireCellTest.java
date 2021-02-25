package googlesheets.test.afr;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.WebDriverService;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.time.Duration;

import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;

public class AFR012_value_ByMaskEntireCellTest extends AFRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1-ilTu3IfEfKs1YiXWpSh-VITNbm8wJrEFHtGlFSZSZg/edit#gid=344783695");
    }

    @Test
    public void valuesByMaskEntireCellAllSheets() throws IOException, InterruptedException {
        runAdvancedFindAndReplace();
        setSearchIn(SearchInSelection.SELECTED_LISTS, 2,3);


        setSearchString("???t?T*");
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

        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_012_value_ByMask.csv");
    }
}
