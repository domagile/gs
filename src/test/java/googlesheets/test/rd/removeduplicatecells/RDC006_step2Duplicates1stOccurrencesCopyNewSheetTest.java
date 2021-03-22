package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC006_step2Duplicates1stOccurrencesCopyNewSheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/154aQCt4f7m53UPp8evYMJnDt4W2UdfCwFdgQwNOlA0w/edit#gid=411751903");
    }


    @Test
    public void duplicates1stOccurrencesCopyNewSheet() throws IOException {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        selectCellType(CellType.DUPLICATES_FIRST_OCCURRENCES);
        setMatchCase(false);
        setSkipEmptyCells(false);
        clickNext();

        clickCopyToAnotherLocation();
        clickNewSheet();
        clickFinishAndClose();

        checkResult(getResultListName("Master - duplicates"), "removeduplicatecells\\RDC_006_duplicates1stOccurrencesCopyNewSheet.csv");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}
