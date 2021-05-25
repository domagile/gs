package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.*;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.MERGE_VALUES;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.LINE_BREAK;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR004_checkLineBreakTest extends CDRTest {
    @Test
    public void checkLineBreak() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F8")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, MERGE_VALUES, LINE_BREAK))
                .build();
        execute(options);

        checkExcelResult("Master", "combineduplicaterows\\CDR_004_checkLineBreak1.xlsx");

    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }


}
