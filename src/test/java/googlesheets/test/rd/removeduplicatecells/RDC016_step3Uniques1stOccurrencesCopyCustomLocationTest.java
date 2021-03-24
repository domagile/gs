package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;


public class RDC016_step3Uniques1stOccurrencesCopyCustomLocationTest extends RDCTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1eIBO3KfEcZGU58rUy6dMVj1CTPPgssNAAsfelq1n0cs/edit#gid=1949568228");
    }


    @Test
    public void uniques1stOccurrencesCopyCustomLocation() throws IOException{
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.UNIQUES_FIRST_OCCURRENCES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickCopyToAnotherLocation();
        clickCustomLocation();
        setCustomLocationRange("'Master'!G1");
        clickFinishAndClose();

        checkResult(getResultListName("Master"), "removeduplicatecells\\RDC_016_uniques1stOccurrencesCopyCustomLocation.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(3);
    }
}
