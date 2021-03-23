package googlesheets.test.rd.removeduplicaterows;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.clickUndo;
import static googlesheets.service.GoogleSheetService.getResultListName;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR042_partiallySelectedRange extends RDRTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/17wOQXHHldMmYDtEOLIep27QQvws7uq5mX-yuicj03aw/edit#gid=209200831");
    }


    @Test
    public void partiallySelectedRange() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        setRange("A1:C35");
        clickNext();
        clickDuplicatesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1,2,3);
        clickNext();
        clickCopyToAnotherLocation();
        clickNewSheet();

        clickFinishAndClose();
        String listName = getResultListName("Master - duplicates");
        checkResult(listName, "removeduplicates\\RDR_042_duplicatesPartiallySelectedRange.csv");
    }

    protected void restoreInitialDocumentState(String resultListName) {
        //todo: replace with some rollback through API
        clickUndo(10);
    }
}
