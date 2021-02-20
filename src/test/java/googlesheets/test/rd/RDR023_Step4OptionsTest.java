package googlesheets.test.rd;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.generic.RDTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicates.RemoveDuplicatesService.*;

public class RDR023_Step4OptionsTest extends RDTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1dKz6IjRWArlgzL58PsIMgYDlUKnbPYYqg2JldpgE3zM/edit#gid=628559773");
    }

    @Test
    public void duplicatesAnd1stOccurrences2And4ColumnsDeleteRowsWithinSelection() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickDuplicatesAnd1stOccurrencesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(2,4);
        clickNext();
        clickDeleteRowsWithinSelectionRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_023_step4duplicatesAnd1stOccurrences2And4ColumnsDeleteRowsWithinSelection.csv");
    }
}
