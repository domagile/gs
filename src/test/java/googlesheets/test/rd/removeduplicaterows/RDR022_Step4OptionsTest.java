package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR022_Step4OptionsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1C0fLPyPAtoFOFu_I_jB2PPfLQV0qaseeXjtiCQbHVjI/edit#gid=1446253218");
    }

    @Test
    public void duplicates2And4ColumnsDeleteRowsWithinSelection() throws IOException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickDuplicatesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(2,4);
        clickNext();
        clickDeleteRowsWithinSelectionRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_022_step4duplicates2And4ColumnsDeleteRowsWithinSelection.csv");
    }
}
