package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.clickUndo;
import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC005_step2DuplicatesCopyNewSheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/10FID7YdjYGfTbYA8veWmDgNQmxT7tZOMoNnj6mtyRNI/edit#gid=33173863");
    }


    @Test
    public void duplicatesCopyNewSheet() throws IOException {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.DUPLICATES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickCopyToAnotherLocation();
        clickNewSheet();
        clickFinishAndClose();

        checkResult(getResultListName("Master - duplicates"), "removeduplicatecells\\RDC_005_duplicatesCopyNewSheet.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}