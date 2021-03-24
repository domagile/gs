package googlesheets.test.afr;

import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;

public class AFR005_FormulaTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/10rEMkpDxfYrN1WfzeszOuAgwUM2vlWhaxHajdEeEcIY/edit#gid=134980356");
    }

    @Test
    public void formula() throws IOException {
        runAdvancedFindAndReplace();
        setSearchIn(SearchInSelection.SELECTED_LISTS, 2);

        setSearchString("IFERROR");
        setMatchCase(false);
        setEntireCell(false);
        setByMask(false);

        setValues(false);
        setFormulas(true);
        setNotes(false);
        setHyperlinks(false);
        setErrors(false);

        clickFindAll();
        runExportAllFoundEntries();
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_005_Formula.csv");
    }
}
