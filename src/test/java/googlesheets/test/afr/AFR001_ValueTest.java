package googlesheets.test.afr;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;

public class AFR001_ValueTest extends AFRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1wXhDHPNarDutnSz-CQk1yaA7D-W6GC3-odsi_-Zf9lw/edit#gid=1061966272");
    }

    @Ignore
    @Test
    public void valuesNumberAllSheets() throws IOException, InterruptedException {
        runAdvancedFindAndReplace();
        setSearchString("600");
        setMatchCase(false);
        setEntireCell(false);
        setByMask(false);
        setValues(true);
        setFormulas(false);
        setNotes(false);
        setHyperlinks(false);
        setErrors(false);

        setSearchIn(SearchInSelection.SELECTED_LISTS, 2, 3);
       clickFindAll();
       runExportAllFoundEntries();
        checkResult("Export results 1", "advancedfindreplace\\AFR_001_valuesNumberAllSheets.csv");
    }
}
