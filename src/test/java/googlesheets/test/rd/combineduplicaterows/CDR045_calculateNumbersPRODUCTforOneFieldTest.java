package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.MAX;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.PRODUCT;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR045_calculateNumbersPRODUCTforOneFieldTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1vewZoliVgZrSpLinc9lVZUqDjEfJJmDClmW5krAWpfE/edit#gid=1749815883");
    }

    @Test
    public void calculateNumbersPRODUCTforOneField() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F8")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, PRODUCT))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_045_calculateNumbersPRODUCTforOneField.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
