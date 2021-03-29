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

public class RDC010_step2Duplicates1stOccurrencesCopyNewSpreadsheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1-lVxb1TXRUDm-NcIRLMjvqd3_ljD59DQIipr3PLlepA/edit#gid=363865499");
    }


    @Test
    public void duplicates1stOccurrencesCopyNewSpreadsheet() throws IOException {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.DUPLICATES_FIRST_OCCURRENCES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickCopyToAnotherLocation();
        clickNewSpreadsheet();
        clickFinish();
        ResultInfo resultInfo = waitForNewSpreadsheetAndClose();

        checkNewSpreadsheetResult("Master", "removeduplicatecells\\RDC_010 - duplicates1stOccurrencesCopyNewSpreadsheet.csv", resultInfo);

    }

}
