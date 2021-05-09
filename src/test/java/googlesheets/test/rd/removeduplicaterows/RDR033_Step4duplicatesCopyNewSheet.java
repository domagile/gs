package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.getFullSheetName;
import static googlesheets.service.generic.google.GoogleSheetService.removeSheetThroughMenu;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR033_Step4duplicatesCopyNewSheet extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/13m8bxkv3Wp4-BIBWx7dDtELiHeckgPCyu7xv50LuFzM/edit#gid=106305428");
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
