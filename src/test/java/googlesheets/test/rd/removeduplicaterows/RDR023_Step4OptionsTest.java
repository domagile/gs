package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR023_Step4OptionsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1dKz6IjRWArlgzL58PsIMgYDlUKnbPYYqg2JldpgE3zM/edit#gid=628559773");
    }

    @Test
    public void duplicatesAnd1stOccurrences2And4ColumnsDeleteRowsWithinSelection() throws IOException {
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
