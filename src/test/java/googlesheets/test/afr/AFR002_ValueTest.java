package googlesheets.test.afr;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;

public class AFR002_ValueTest extends AFRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1z2ppCCSqI7JR9uCSrqjybSmy3KchM5HdMjVUD88ITYw/edit#gid=1188486544");
    }

    @Ignore
    @Test
    public void valuesTextAllSheets() throws IOException, InterruptedException {
        runAdvancedFindAndReplace();
        setSearchString("John");
        setMatchCase(false);
        setEntireCell(false);
        setByMask(false);
        setValues(true);
        setFormulas(false);
        setNotes(false);
        setHyperlinks(false);
        setErrors(false);

        setSearchIn(SearchInSelection.ALL);
       clickFindAll();
       runExportAllFoundEntries();
        checkResult("Export results 1", "advancedfindreplace\\AFR_001_valuesNumberAllSheets.csv");
    }
}
