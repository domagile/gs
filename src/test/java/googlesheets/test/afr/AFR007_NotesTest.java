package googlesheets.test.afr;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;

public class AFR007_NotesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/14_odSNasj000Uxr8QjbSkv19bc-Q9Wyh2URub6vWz0I/edit#gid=125546058");
    }

    @Test
    public void notes() throws IOException, InterruptedException {
        runAdvancedFindAndReplace();
        setSearchIn(SearchInSelection.SELECTED_LISTS, 2);


        setSearchString("Note");
        setMatchCase(false);
        setEntireCell(false);
        setByMask(false);

        setValues(false);
        setFormulas(false);
        setNotes(true);
        setHyperlinks(false);
        setErrors(false);

        clickFindAll();
        runExportAllFoundEntries();
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_007_Notes.csv");
    }
}
