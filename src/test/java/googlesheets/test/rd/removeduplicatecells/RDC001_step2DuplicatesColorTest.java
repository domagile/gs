package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getFullSheetName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC001_step2DuplicatesColorTest extends RDCTest {
    @BeforeClass
    public static void openDocument() {
      openDocument("https://docs.google.com/spreadsheets/d/1c_5vVrPUfznnJeqUqVXpa1bbTF60B57L3eDNuvVe-vU/edit#gid=1125282730");


    }


    @Test
    public void duplicatesColor() {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.DUPLICATES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickFillWithColor();

        clickFinishAndClose();

        checkExcelResult(getFullSheetName("Master"), "removeduplicatecells\\RDC_001_duplicatesColor.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}
