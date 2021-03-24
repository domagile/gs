package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR011_Step2OptionsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1VooZGFaBF6JP2gIUU0IJlo9_FHk0y0diWOWA2X95u14/edit#gid=341212855");
    }

    @Test
    public void duplicates_1stOccurrencesAllColumns() throws IOException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        setRange("A1:C41");
        clickNext();
        clickDuplicatesAnd1stOccurrencesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1,2,3);
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_011_step2options_duplicates_1stOccurrencesAllColumns.csv");
    }
}
