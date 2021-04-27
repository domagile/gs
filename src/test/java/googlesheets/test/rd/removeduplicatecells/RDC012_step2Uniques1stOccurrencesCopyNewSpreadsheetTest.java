package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC012_step2Uniques1stOccurrencesCopyNewSpreadsheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1Tyo_s7jwKC8K3nbdPRJGuYvL5pxf1Hs3TRNCgSxltWY/edit#gid=328857161");
    }


    @Test
    public void uniques1stOccurrencesCopyNewSpreadsheet() {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.UNIQUES_FIRST_OCCURRENCES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickCopyToAnotherLocation();
        clickNewSpreadsheet();
        clickFinish();
        ResultInfo resultInfo = waitForNewSpreadsheetAndClose();

        checkNewSpreadsheetResult("Master", "removeduplicatecells\\RDC_012 - uniques1stOccurrencesCopyNewSpreadsheet.csv", resultInfo);

    }

}
