package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.MERGE_VALUES;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.COMMA;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.SUM;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR023_calculateNumbersSUMforOneFieldTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1mrEp728EI1WGkCv8WqkJ8xzQCetrNsj5FFZla9tHPpI/edit#gid=175435279");
    }

    @Test
    public void calculateNumbersSUM() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F8")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, SUM))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_023_calculateNumbersSUM.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
