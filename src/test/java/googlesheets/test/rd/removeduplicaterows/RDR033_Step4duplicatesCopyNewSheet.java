package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.getFullSheetName;
import static googlesheets.service.generic.google.GoogleSheetService.removeSheetThroughMenu;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR033_Step4duplicatesCopyNewSheet extends RDRTest {
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
        clickCopyToAnotherLocation();
        clickNewSheet();

        clickFinishAndClose();
        checkResult(getFullSheetName("Master - duplicates"), "removeduplicaterows\\RDR_033_step4duplicatesAllColumnsCopyNewSheet.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        removeSheetThroughMenu(resultListName);
    }
}
