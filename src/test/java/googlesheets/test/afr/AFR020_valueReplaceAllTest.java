package googlesheets.test.afr;

import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class AFR020_valueReplaceAllTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1nqB-NngVoB08aWqglkBCiv84XoAyTRMV1G1PVacGshM/edit#gid=1264786995");
    }

    @Test
    public void valuesRepleceAll() throws IOException {
        runAdvancedFindAndReplace();
        setSearchIn(SearchInSelection.SELECTED_LISTS, 2,3);


        setSearchString("david james");
        setMatchCase(false);
        setEntireCell(false);
        setByMask(false);

        setValues(true);
        setFormulas(false);
        setNotes(false);
        setHyperlinks(false);
        setErrors(false);

        clickFindAll();
        setReplaceString("William James");
        clickReplaceAll();

        runExportAllFoundEntries();
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_020_valueReplaceAll.csv");
    }


    protected void restoreInitialDocumentState(String resultListName) {
        //fixme: restoration of data should be done through API
        //wait after CSV download start
        sleep(2000);
        clickUndo();
        clickUndo();
        clickUndo();
    }
}
