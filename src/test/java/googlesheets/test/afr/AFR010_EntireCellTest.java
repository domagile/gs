package googlesheets.test.afr;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;

public class AFR010_EntireCellTest extends AFRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/118xZTIqTU2bHVMmhzJxjwZBX4z7X853gQdeWEI-Eiao/edit#gid=1810214049");
    }

    @Test
    public void valuesEntireCaseAllSheets() throws IOException, InterruptedException {
        runAdvancedFindAndReplace();
        setSearchIn(SearchInSelection.SELECTED_LISTS, 2,3);


        setSearchString("James Puls");
        setMatchCase(false);
        setEntireCell(true);
        setByMask(false);

        setValues(true);
        setFormulas(false);
        setNotes(false);
        setHyperlinks(false);
        setErrors(false);

        clickFindAll();
        runExportAllFoundEntries();
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_010_valueEntireCell.csv");
    }
}
