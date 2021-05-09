package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR037_Step4duplicatesMoveNewSheetTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1h3HTb9NLZy6CofRdV1ihoms0hRbulq5mZ4fLJc7moM4/edit#gid=1904782437");

    }


    @Test
    public void duplicatesAllColumnsCopyNewSheet() {
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
        checkResult(getResultSheetName("Master - duplicates"), "removeduplicaterows\\RDR_037_step4duplicatesMoveNewSheet.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(15);
    }
}
