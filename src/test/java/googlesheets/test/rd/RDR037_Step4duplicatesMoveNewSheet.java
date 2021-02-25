package googlesheets.test.rd;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.rd.generic.RDTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.RemoveDuplicatesService.*;

public class RDR037_Step4duplicatesMoveNewSheet extends RDTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1h3HTb9NLZy6CofRdV1ihoms0hRbulq5mZ4fLJc7moM4/edit#gid=1904782437");

    }


    @Test
    public void duplicatesAllColumnsCopyNewSheet() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickDuplicatesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1,2,3);
        clickNext();
        clickMoveToAnotherLocation();
        clickNewSheet();

        clickFinishAndClose();
        checkResult(getResultListName("Master - duplicates"), "removeduplicates\\RDR_037_step4duplicatesMoveNewSheet.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) throws InterruptedException {
        clickUndo(15);
    }
}
