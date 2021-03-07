package googlesheets.test.rd.removeduplicaterows;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR032_Step4AddStatusTest extends RDRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1fSXm-QrWQ-maZmU1WKnLV0h26rf4SKurVimBch7KQ_0/edit#gid=531302245");
    }


    @Test
    public void duplicatesAllColumnsAddStatus() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickDuplicatesRadioButton();
        clickNext();
        setMyTableHasHeaders(false);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1,2,3,4,5);
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_032_step4duplicatesAllColumnsAddStatus.csv");
    }
}
