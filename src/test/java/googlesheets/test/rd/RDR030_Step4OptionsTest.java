package googlesheets.test.rd;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.generic.RDTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicates.RemoveDuplicatesService.*;

public class RDR030_Step4OptionsTest extends RDTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1FYTc0nzN2PjwR0ubM1JlP_O0IyZTaUww3J6FF2qW_xQ/edit#gid=1964008673");
    }


    @Test
    public void UniquesAllColumnsClearValues() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickUniquesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1,2,3,4,5);
        clickNext();
        clickClearValuesRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_030_step4UniquesAllColumnsClearValues.csv");
    }
}
