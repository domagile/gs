package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.MERGE_VALUES;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.*;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR013_check3keyFieldsTest extends CDRTest {
    @Test
    public void check3keyFields() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:H10")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1, 2, 3)
                .mergedColumns(new MergedColumn(1, MERGE_VALUES, COMMA),
                        new MergedColumn(2, MERGE_VALUES, COMMA),
                        new MergedColumn(3, MERGE_VALUES, COMMA))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_013_check3keyFields.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }


}
