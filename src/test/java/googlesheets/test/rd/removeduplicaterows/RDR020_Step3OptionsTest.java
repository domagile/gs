package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR020_Step3OptionsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1xW_AWiKyAPz7VbiiGG0ju6_vYV-XhMcewzPzi21uq2U/edit#gid=253071245");
    }

    @Test
    public void uniques_SkipEmptyCellsFirst3Columns() throws IOException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickUniquesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(true);
        selectColumnsToSearchIn(1,2,3);
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_020_step3uniques_SkipEmptyCellsFirst3Columns.csv");
    }
}
