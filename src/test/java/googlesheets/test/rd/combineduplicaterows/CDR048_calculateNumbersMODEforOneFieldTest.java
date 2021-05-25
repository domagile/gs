package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.MODE;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR048_calculateNumbersMODEforOneFieldTest extends CDRTest {
    @Test
    public void calculateNumbersMODEforOneField() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("B3:G17")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1, 2, 3)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, MODE),
                        new MergedColumn(2, CALCULATE_NUMBERS, MODE),
                        new MergedColumn(3, CALCULATE_NUMBERS, MODE))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_048_calculateNumbersMODEforOneField.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
