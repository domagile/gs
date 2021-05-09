package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR043_partiallySelectedRange extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1UnoEgnOs8Uf9AiGov2DbYfEb_MxsdW-BbaEkJ2lIO6s/edit#gid=1351857154");
    }


    @Test
    public void partiallySelectedRange() {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        setRange("A15:C39");
        sleep(1000);
        clickNext();
        clickDuplicatesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1,2,3);
        clickNext();
        clickDeleteRowsWithinSelectionRadioButton();

        clickFinishAndClose();
        checkResult("Master", "removeduplicaterows\\RDR_043_duplicatesPartiallySelectedRange");
    }

}
