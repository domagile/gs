package googlesheets.test.rd.removeduplicaterows;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR031_Step4ClearValuesTest extends RDRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1_njqTMZcmfysccTNTLLSVsUZU9FpZNvN6WtXPBz3Mr8/edit#gid=799099187");
    }


    @Test
    public void Uniques1stOccurrencesAllColumnsClearValues() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickUniquesAnd1stOccurrencesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1,2,3,4,5);
        clickNext();
        clickClearValuesRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_031_step4uniquesAnd1thOccurrencsClearValues.csv");
    }
}
