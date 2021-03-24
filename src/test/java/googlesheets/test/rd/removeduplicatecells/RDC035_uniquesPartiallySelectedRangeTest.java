package googlesheets.test.rd.removeduplicatecells;

import googlesheets.service.removeduplicates.removeduplicatecells.CellType;
import googlesheets.test.rd.removeduplicatecells.generic.RDCTest;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatecells.RemoveDuplicatesCellsService.*;

public class RDC035_uniquesPartiallySelectedRangeTest extends RDCTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1FO1IgTWj6W8KL8R3Hjq9RAZWCxlqkmZVxzlieAMrCjA/edit#gid=881510639");
    }

@Ignore
    @Test
    public void uniquesMatchCase() throws IOException {
        runFindDuplicateOrUniqueCells();
        setCreateBackupCopyOfSheet(false);
        setRange("A1:C35");
        clickNext();

        selectCellType(CellType.UNIQUES);
        setMatchCase(true);
        setSkipEmptyCells(true);
        clickNext();

        clickFillWithColor();
        clickFinishAndClose();

        checkExcelResult(getResultListName("Master"), "removeduplicatecells\\RDC_035_uniquesPartiallySelectedRange.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(2);
    }
}
