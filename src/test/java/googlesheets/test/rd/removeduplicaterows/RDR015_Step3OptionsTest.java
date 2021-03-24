package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR015_Step3OptionsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1xUqQRCwBuEoDp--9-ZDyRRcEcn_J6AG33EcSTJK5E74/edit#gid=586671925");
    }

    @Test
    public void duplicatesAnd1stOccurrencesSkipEmptyCellsFirstColumns() throws IOException {
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
