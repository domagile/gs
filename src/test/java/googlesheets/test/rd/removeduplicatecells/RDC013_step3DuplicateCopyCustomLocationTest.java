package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;


public class RDC013_step3DuplicateCopyCustomLocationTest extends RDCTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        openDocument("https://docs.google.com/spreadsheets/d/10PiV_zZBs2BbkK7klfBnatGHGTishkQz8jci6d0xsTI/edit#gid=917760029");
    }


    @Test
    public void duplicateCopyCustomLocation() throws IOException{
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.DUPLICATES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickCopyToAnotherLocation();
        clickCustomLocation();
        setCustomLocationRange("'Master'!G1");
        clickFinishAndClose();

        checkResult(getResultListName("Master"), "removeduplicatecells\\RDC_013_duplicateCopyCustomLocation.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(3);
    }
}
