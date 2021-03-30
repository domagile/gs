package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.MERGE_VALUES;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.SEMICOLON;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR017_checkDeleteDuplicateValuesAndSkipEmptyCellsTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1Oa-aumR_H-X8pbEcV0Oh7n56qlJPrhrZNUVUDKt1R10/edit#gid=785633547");
    }

    @Test
    public void checkDeleteDuplicateValuesAndSkipEmptyCells() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F11")
                .dataHasHeaderRow(true)
                .deleteDuplicateValues(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, MERGE_VALUES, SEMICOLON))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_017_checkDeleteDuplicateValuesAndSkipEmptyCells.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }


}
