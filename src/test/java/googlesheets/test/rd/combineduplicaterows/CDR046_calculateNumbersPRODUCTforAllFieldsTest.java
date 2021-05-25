package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.PRODUCT;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR046_calculateNumbersPRODUCTforAllFieldsTest extends CDRTest {
    @Test
    public void calculateNumbersPRODUCTforAllFields() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("A1:K9")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, PRODUCT),
                        new MergedColumn(2, CALCULATE_NUMBERS, PRODUCT),
                        new MergedColumn(3, CALCULATE_NUMBERS, PRODUCT),
                        new MergedColumn(4, CALCULATE_NUMBERS, PRODUCT),
                        new MergedColumn(5, CALCULATE_NUMBERS, PRODUCT),
                        new MergedColumn(6, CALCULATE_NUMBERS, PRODUCT),
                        new MergedColumn(7, CALCULATE_NUMBERS, PRODUCT),
                        new MergedColumn(8, CALCULATE_NUMBERS, PRODUCT),
                        new MergedColumn(9, CALCULATE_NUMBERS, PRODUCT),
                        new MergedColumn(10, CALCULATE_NUMBERS, PRODUCT))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_046_calculateNumbersPRODUCTforAllFields.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
