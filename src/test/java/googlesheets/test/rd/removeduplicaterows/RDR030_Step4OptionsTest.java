package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR030_Step4OptionsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1FYTc0nzN2PjwR0ubM1JlP_O0IyZTaUww3J6FF2qW_xQ/edit#gid=1964008673");
    }


    @Test
    public void UniquesAllColumnsClearValues() {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        setRange("A1:E42");
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
        checkResult("Master", "removeduplicaterows\\RDR_030_step4UniquesAllColumnsClearValues.csv");
    }
}
