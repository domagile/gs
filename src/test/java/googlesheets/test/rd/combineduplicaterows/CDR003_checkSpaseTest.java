package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.*;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.MERGE_VALUES;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.SEMICOLON;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.SPACE;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.combineduplicaterows.CombineDuplicateRowsService.*;


public class CDR003_checkSpaseTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1HsuUna-K66fD8UYJ67UXgibIvUIRc-8X9JWTxeVl7Ug/edit#gid=574185352");
    }

    @Test
    public void checkSpace() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F8")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, MERGE_VALUES, SPACE))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_003_checkSpace.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo(5);
    }
}
