package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR040_Step4DuplicatesSelectedRangeColorsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1owHh_06PYpm7wZlPiX58cx1XXRr5ttD5d0sVsxm40AU/edit#gid=1951119487");
    }

    @Test
    public void duplicatesSelectedRangeColor() throws IOException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        clickDuplicatesRadioButton();
        clickNext();

        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1,2,3,4,5);
        clickNext();

        clickFillWithColor();
        clickFinishAndClose();
        checkExcelResult("Master", "removeduplicaterows\\RDR_040_step4duplicatesColor.xlsx");
    }
    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(5);
    }
}
