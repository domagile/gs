package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.COUNT;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR027_calculateNumbersCOUNTforAllFieldsTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1vbQVk1y4ZHWVyGHHe6yVVsmoy3-fuvADJdwfWRF9B3s/edit#gid=647164091");
    }

    @Test
    public void calculateNumbersCOUNTforAllFields() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("A1:K9")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, COUNT),
                        new MergedColumn(2, CALCULATE_NUMBERS, COUNT),
                        new MergedColumn(3, CALCULATE_NUMBERS, COUNT),
                        new MergedColumn(4, CALCULATE_NUMBERS, COUNT),
                        new MergedColumn(5, CALCULATE_NUMBERS, COUNT),
                        new MergedColumn(6, CALCULATE_NUMBERS, COUNT),
                        new MergedColumn(7, CALCULATE_NUMBERS, COUNT),
                        new MergedColumn(8, CALCULATE_NUMBERS, COUNT),
                        new MergedColumn(9, CALCULATE_NUMBERS, COUNT),
                        new MergedColumn(10, CALCULATE_NUMBERS, COUNT))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_027_calculateNumbersCOUNTforAllFields.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
