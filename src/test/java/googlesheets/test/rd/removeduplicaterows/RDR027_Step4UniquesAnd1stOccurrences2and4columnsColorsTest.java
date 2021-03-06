package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR027_Step4UniquesAnd1stOccurrences2and4columnsColorsTest extends RDRTest {
    @Test
    public void uniquesAnd1stOccurrences2and4columnsColors() {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();

        clickDuplicatesAnd1stOccurrencesRadioButton();
        clickNext();

        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(2,4);
        clickNext();

        clickFillWithColor();
        clickFinishAndClose();
        checkExcelResult("Master", "removeduplicaterows\\RDR_027_step4uniquesAnd1stOccurrences2and4columnsColors.xlsx");
    }
    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(5);
    }
}
