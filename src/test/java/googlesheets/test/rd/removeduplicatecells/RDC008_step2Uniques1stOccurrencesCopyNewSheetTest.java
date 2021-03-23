package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC008_step2Uniques1stOccurrencesCopyNewSheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1zMTYZf-Y8_bfM2-Npi98jnVtdUPTJoFuaojKERHnjEA/edit#gid=757679063");
    }


    @Test
    public void uniques1stOccurrencesCopyNewSheet() throws IOException {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.UNIQUES_FIRST_OCCURRENCES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickCopyToAnotherLocation();
        clickNewSheet();
        clickFinishAndClose();

        checkResult(getResultListName("Master - uniques"), "removeduplicatecells\\RDC_008_uniques1stOccurrencesCopyNewSheet.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}