package googlesheets.test.rd;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.generic.RDTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicates.RemoveDuplicatesService.*;

public class RDR029_Step4OptionsTest extends RDTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/15lOrnt0rGBTsSkJmJS9L2bMubQtoFfD7XlqelDouEiQ/edit#gid=750389418");
    }


    @Test
    public void duplicatesAnd1stOccurrencesAllColumnsClearValues() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickDuplicatesAnd1stOccurrencesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1,2,3,4,5);
        clickNext();
        clickClearValuesRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_029_step4duplicatesAllColumnsClearValues.csv");
    }
}
