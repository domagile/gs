package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR026_Step4UniquesColors2and4columnsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1kqLJB-yugH7a7FvOA42XhOrazZ2qY8XzutzKVDRCwow/edit#gid=548035173");
    }

    @Test
    public void uniques2And4ColumnsColor() {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        clickUniquesRadioButton();
        clickNext();

        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(2,4);
        clickNext();

        clickFillWithColor();
        clickFinishAndClose();
        checkExcelResult("Master", "removeduplicaterows\\RDR_026_step4Uniques2And4ColumnsColor.xlsx");
    }
    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(5);
    }
}
