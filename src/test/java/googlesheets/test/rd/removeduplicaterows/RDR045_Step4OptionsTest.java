package googlesheets.test.rd.removeduplicaterows;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR045_Step4OptionsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1zgtgo_PDNDNS7nUl3i_o0RzE4Z74F07dFxUHBZgdZA8/edit#gid=2108987119");
    }


    @Test
    public void uniquesAnd1stOccurrences2And4ColumnsDeleteRowsWithinSelection() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickUniquesAnd1stOccurrencesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(2,4);
        clickNext();
        clickDeleteRowsWithinSelectionRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_045_step4uniquesAnd1stOccurrences2And4ColumnsDeleteRowsWithinSelection.csv");
    }
}
