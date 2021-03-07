package googlesheets.test.rd.removeduplicaterows;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR015_Step3OptionsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1xUqQRCwBuEoDp--9-ZDyRRcEcn_J6AG33EcSTJK5E74/edit#gid=586671925");
    }

    @Test
    public void duplicatesAnd1stOccurrencesSkipEmptyCellsFirstColumns() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickDuplicatesAnd1stOccurrencesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(true);
        selectColumnsToSearchIn(1);
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_015_step3duplicatesAnd1stOccurrencesSkipEmptyCellsFirstColumns.csv");
    }
}
