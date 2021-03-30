package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;


public class RDC028_step3Uniques1stOccurrencesClearValuesTest extends RDCTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        openDocument("https://docs.google.com/spreadsheets/d/1KkjwbClSxez1bJB2NO2_4tMx8yvEub6eXE2hFd5tJl0/edit#gid=1489084905");
    }


    @Test
    public void uniques1stOccurrencesClearValues() throws IOException{
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.UNIQUES_FIRST_OCCURRENCES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickClearValuesRadioButton();
       // setCustomLocationRange("'Master'!G1");
        clickFinishAndClose();

        checkResult(getResultListName("Master"), "removeduplicatecells\\RDC_028_uniques1stOccurrencesClearValues.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(3);
    }
}