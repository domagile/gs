package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.generic.addon.ResultInfo;
import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC011_step2UniquesCopyNewSpreadsheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument()  {
        openDocument("https://docs.google.com/spreadsheets/d/1FIvrf5_g16jL9IfIcrOEyL_AftnGHoTMxz-F5CDCGck/edit#gid=12224350");
    }


    @Test
    public void uniquesCopyNewSpreadsheet() throws IOException {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.UNIQUES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickCopyToAnotherLocation();
        clickNewSpreadsheet();
        clickFinish();
        ResultInfo resultInfo = waitForNewSpreadsheetAndClose();

        checkNewSpreadsheetResult("Master", "removeduplicatecells\\RDC_011 - uniquesCopyNewSpreadsheet.csv", resultInfo);
    }

}
