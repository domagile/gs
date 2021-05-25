package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.COUNTA;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR031_calculateNumbersCOUNTAforAllFieldsTest extends CDRTest {
    @Test
    public void calculateNumbersCOUNTforAllFields() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("A1:K9")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, COUNTA),
                        new MergedColumn(2, CALCULATE_NUMBERS, COUNTA),
                        new MergedColumn(3, CALCULATE_NUMBERS, COUNTA),
                        new MergedColumn(4, CALCULATE_NUMBERS, COUNTA),
                        new MergedColumn(5, CALCULATE_NUMBERS, COUNTA),
                        new MergedColumn(6, CALCULATE_NUMBERS, COUNTA),
                        new MergedColumn(7, CALCULATE_NUMBERS, COUNTA),
                        new MergedColumn(8, CALCULATE_NUMBERS, COUNTA),
                        new MergedColumn(9, CALCULATE_NUMBERS, COUNTA),
                        new MergedColumn(10, CALCULATE_NUMBERS, COUNTA))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_031_calculateNumbersCOUNTAforAllFields.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
