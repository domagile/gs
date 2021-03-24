package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;


public class RDC014_step3Duplicate1stOccurrencesCopyCustomLocationTest extends RDCTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1bzwOyGjuurrX0K9iEwAJfsNSFGODt-RVg5L8rHrw7tc/edit#gid=24782255");
    }


    @Test
    public void duplicate1stOccurrencesCopyCustomLocation() throws IOException{
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.DUPLICATES_FIRST_OCCURRENCES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickCopyToAnotherLocation();
        clickCustomLocation();
        setCustomLocationRange("'Master'!G1");
        clickFinishAndClose();

        checkResult(getResultListName("Master"), "removeduplicatecells\\RDC_014_duplicate1stOccurrencesCopyCustomLocation.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(3);
    }
}
