package googlesheets.test.rd.removeduplicaterows;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR013_Step2OptionsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1gnt3s7FoK9FbNfBOh_fkeNPdKQqDWMtrJdNtoT1WhWk/edit#gid=1868443686");
    }

    @Test
    public void uniques_1stOccurrencesAllColumns() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        Thread.sleep(1000);
        setRange("A1:C41");
        Thread.sleep(1000);
        clickNext();
        clickUniquesAnd1stOccurrencesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1,2,3);
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_013_step2uniques_1stOccurrencesAllColumns.csv");
    }
}
