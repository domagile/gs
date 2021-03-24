package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC025_step3DuplicatesClearValuesTest extends RDRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        openDocument("https://docs.google.com/spreadsheets/d/1k1-Wlc3mOeRDFtBtIVz23uxpVim3sbScl1p6-JB2pG0/edit#gid=1538338207");
    }


    @Test
    public void duplicatesClearValues() throws IOException {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.DUPLICATES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickClearValuesRadioButton();
        clickFinishAndClose();

        checkResult(getResultListName("Master"), "removeduplicatecells\\RDC_025_duplicatesClearValues.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(5);
    }
}
