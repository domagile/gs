package googlesheets.test.rd.removeduplicaterows;

import googlesheets.test.rd.removeduplicaterows.generic.RDRTest;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.removeduplicatesrows.RemoveDuplicatesRowsService.*;

public class RDR025_Step4Duplicates1stOccurrencesColors2and4columnsTest extends RDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1CjTNj207fA-Fgnn1VAqN1ceWzZxOw2zJ9IXJw5nq-6c/edit#gid=1715489734");
    }

    @Test
    public void duplicatesAnd1stOccurrences2And4ColumnsColor() throws IOException {
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
        checkExcelResult("Master", "removeduplicaterows\\RDR_025_step4duplicatesAnd1stOccurrences2And4ColumnsColor.xlsx");
    }
    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(5);
    }
}
