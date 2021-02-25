package googlesheets.test.afr;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;

public class AFR001_ValuesNumberTest extends AFRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1wXhDHPNarDutnSz-CQk1yaA7D-W6GC3-odsi_-Zf9lw/edit#gid=1061966272");
    }

    @Test
    public void valuesNumber() throws IOException, InterruptedException {
        runAdvancedFindAndReplace();
        //fill it first because other fields are reloaded after loading of this table
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
        runExportAllFoundEntries();
        String resultListName = getResultListName("Export results ");
        checkResult(resultListName, "advancedfindreplace\\AFR_001_valuesNumberAllSheets.csv");
    }
}
