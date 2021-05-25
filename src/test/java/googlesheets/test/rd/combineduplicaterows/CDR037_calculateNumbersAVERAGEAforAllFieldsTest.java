package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.AVERAGEA;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR037_calculateNumbersAVERAGEAforAllFieldsTest extends CDRTest {
    @Test
    public void calculateNumbersAVERAGEAforAllFields() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("A1:K9")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, AVERAGEA),
                        new MergedColumn(2, CALCULATE_NUMBERS, AVERAGEA),
                        new MergedColumn(3, CALCULATE_NUMBERS, AVERAGEA),
                        new MergedColumn(4, CALCULATE_NUMBERS, AVERAGEA),
                        new MergedColumn(5, CALCULATE_NUMBERS, AVERAGEA),
                        new MergedColumn(6, CALCULATE_NUMBERS, AVERAGEA),
                        new MergedColumn(7, CALCULATE_NUMBERS, AVERAGEA),
                        new MergedColumn(8, CALCULATE_NUMBERS, AVERAGEA),
                        new MergedColumn(9, CALCULATE_NUMBERS, AVERAGEA),
                        new MergedColumn(10, CALCULATE_NUMBERS, AVERAGEA))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_037_calculateNumbersAVERAGEAforAllFields.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
