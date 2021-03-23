package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;


public class RDC015_step3UniquesCopyCustomLocationTest extends RDCTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1SgYSzPhAXozD-jKxzMCS38kUJkhFkResde1TDm3H3dE/edit#gid=1366297283");
    }


    @Test
    public void uniquesCopyCustomLocation() throws IOException{
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        sleep(1000);
        clickNext();

        selectCellType(CellType.UNIQUES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickCopyToAnotherLocation();
        clickCustomLocation();
        setCustomLocationRange("'Master'!G1");
        clickFinishAndClose();

        checkResult(getResultListName("Master"), "removeduplicatecells\\RDC_015_uniquesCopyCustomLocation.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(3);
    }
}