package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR034_Step4duplicatesCopyCustomLocation extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1vX3oT05WGl1H0id60Qnufq9FFwot4m6GgIs1U3WWGYM/edit#gid=1800041437");
    }


    @Test
    public void duplicatesAllColumnsCopyNewSheet() throws IOException {
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
        clickCopyToAnotherLocation();
        clickCustomLocation();

        setCustomLocationRange("'Master'!F1");

        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_034_step4duplicatesAllColumnsCopyCustomLocation.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        //todo: replace with some rollback through API
        clickUndo(10);
    }
}
