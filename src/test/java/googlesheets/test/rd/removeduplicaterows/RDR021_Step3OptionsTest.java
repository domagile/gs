package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR021_Step3OptionsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1PV7_wAKb2aRuW0DH3u3JjioRIlZcW9JDdzVR-PxgHu0/edit#gid=1646228099");
    }

    @Test
    public void uniques_1stOccurrencesSkipEmptyCellsFirst3Columns() throws IOException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickUniquesAnd1stOccurrencesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(true);
        selectColumnsToSearchIn(1,2,3);
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_021_step3uniques_1stOccurrencesSkipEmptyCellsFirst3Columns.csv");
    }
}
