package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC030_step2DuplicatesMatchCaseTest extends RDCTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1HahxWb0Moy_13dLreKNQqQIN0bZgHuiE__ZHCKRS4qY/edit#gid=1386473968");
    }


    @Test
    public void duplicatesMatchCase() throws IOException {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.DUPLICATES);
        setMatchCase(true);
        setSkipEmptyCells(false);
        clickNext();

        clickFillWithColor();

        clickFinishAndClose();

        checkExcelResult(getResultListName("Master"), "removeduplicatecells\\RDC_030_duplicatesMatchCase.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}
