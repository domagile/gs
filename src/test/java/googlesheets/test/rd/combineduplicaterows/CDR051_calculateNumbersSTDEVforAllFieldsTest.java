package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.MODE;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.STDEV;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR051_calculateNumbersSTDEVforAllFieldsTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1lHXjEVEnmJVlyf2FWjr0pMANBACds1tRoyPuZFqE-cU/edit#gid=1514339323");
    }

    @Test
    public void calculateNumbersSTDEVforAllFields() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("A1:K9")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, STDEV),
                        new MergedColumn(2, CALCULATE_NUMBERS, STDEV),
                        new MergedColumn(3, CALCULATE_NUMBERS, STDEV),
                        new MergedColumn(4, CALCULATE_NUMBERS, STDEV),
                        new MergedColumn(5, CALCULATE_NUMBERS, STDEV),
                        new MergedColumn(6, CALCULATE_NUMBERS, STDEV),
                        new MergedColumn(7, CALCULATE_NUMBERS, STDEV),
                        new MergedColumn(8, CALCULATE_NUMBERS, STDEV),
                        new MergedColumn(9, CALCULATE_NUMBERS, STDEV),
                        new MergedColumn(10, CALCULATE_NUMBERS, STDEV))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_051_calculateNumbersSTDEVforAllFields.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
