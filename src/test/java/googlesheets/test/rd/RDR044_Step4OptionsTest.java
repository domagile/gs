package googlesheets.test.rd;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.generic.RDTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicates.RemoveDuplicatesService.*;

public class RDR044_Step4OptionsTest extends RDTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1J-wiH-JeFZoir6u09rYsmLLv6GpeUTLYZBDj6_o_t9w/edit#gid=1474619239");
    }

    //uniquesAnd1stOccurrences2And4ColumnsDeleteRowsWithinSelection
    @Test
    public void uniques2And4ColumnsDeleteRowsWithinSelection() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickUniquesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(2,4);
        clickNext();
        clickDeleteRowsWithinSelectionRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_044_step4uniques2And4ColumnsDeleteRowsWithinSelection.csv");
    }
}
