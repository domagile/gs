package googlesheets.test.afr;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.*;
import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;

public class AFR019_valueReplaceTest extends AFRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/11pEa5QQFme1KqSfelzOqjyZQKVETXCu5DUE2OCPERI4/edit#gid=606209076");
    }

    @Test
    public void valuesRepleceAllSheets() throws IOException, InterruptedException {
        runAdvancedFindAndReplace();
        setSearchIn(SearchInSelection.SELECTED_LISTS, 2,3);


        setSearchString("bill");
        setMatchCase(false);
        setEntireCell(false);
        setByMask(false);

        setValues(true);
        setFormulas(false);
        setNotes(false);
        setHyperlinks(false);
        setErrors(false);

        clickFindAll();
        setReplaceString("william");
        clickReplace();

        runExportAllFoundEntries();
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_019_valueReplace.csv");
    }


    protected void restoreInitialDocumentState(String resultListName) throws InterruptedException {
        //fixme: restoration of data should be done through API
        //wait after CSV download start
        Thread.sleep(2000);
        clickUndo();
        clickUndo();
        clickUndo();
    }
}
