package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultSheetName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.setRange;

public class RDC018_step3Duplicates1stOccurrencesMoveNewSheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1vkssUI0wE8w5_OCNON7EgFQJoYGuf3VET-7IgvavvpA/edit#gid=1569284922");
    }


    @Test
    public void duplicates1stOccurrencesMoveNewSheet() {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        setRange("A1:C25");
        clickNext();

        selectCellType(CellType.DUPLICATES_FIRST_OCCURRENCES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickCopyToAnotherLocation();
        clickNewSheet();
        clickFinishAndClose();

        checkResult(getResultSheetName("Master - duplicates"), "removeduplicatecells\\RDC_018_duplicates1stOccurrencesMoveNewSheet.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}
