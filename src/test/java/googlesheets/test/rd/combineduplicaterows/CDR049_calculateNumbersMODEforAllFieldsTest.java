package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.*;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR049_calculateNumbersMODEforAllFieldsTest extends CDRTest {
    @Test
    public void calculateNumbersMODEforAllFields() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("A1:K9")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, MODE),
                        new MergedColumn(2, CALCULATE_NUMBERS, MODE),
                        new MergedColumn(3, CALCULATE_NUMBERS, MODE),
                        new MergedColumn(4, CALCULATE_NUMBERS, MODE),
                        new MergedColumn(5, CALCULATE_NUMBERS, MODE),
                        new MergedColumn(6, CALCULATE_NUMBERS, MODE),
                        new MergedColumn(7, CALCULATE_NUMBERS, MODE),
                        new MergedColumn(8, CALCULATE_NUMBERS, MODE),
                        new MergedColumn(9, CALCULATE_NUMBERS, MODE),
                        new MergedColumn(10, CALCULATE_NUMBERS, MODE))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_049_calculateNumbersMODEforAllFields.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
