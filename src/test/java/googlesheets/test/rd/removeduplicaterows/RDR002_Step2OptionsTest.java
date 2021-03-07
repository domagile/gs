package googlesheets.test.rd.removeduplicaterows;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR002_Step2OptionsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1WOMIAzu80C1QPG6rydREvm9E3F6KcuQmdpLy-NjXpWM/edit#gid=1975763608");
    }


    @Test
    public void duplicates_matchCase() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickDuplicatesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(true);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1);
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_002_step2options_duplicates.csv");
    }
}
