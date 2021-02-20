package googlesheets.test.rd;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.generic.RDTest;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicates.RemoveDuplicatesService.*;

public class RDR019_Step3OptionsTest extends RDTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1wzcLj5KCdUg5At5fCIJdsZUsh8lIyjbYZIYmK_O5Dnc/edit#gid=1260297818");
    }

    @Test
    public void duplicates_1stOccurrencesSkipEmptyCellsFirst3Columns() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickDuplicatesAnd1stOccurrencesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(true);
        selectColumnsToSearchIn(1,2,3);
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_019_step3duplicates_1stOccurrencesSkipEmptyCellsFirst3Columns.csv");
    }
}
