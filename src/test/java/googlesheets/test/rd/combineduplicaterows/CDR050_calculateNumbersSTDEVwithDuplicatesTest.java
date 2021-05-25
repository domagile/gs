package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.STDEV;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR050_calculateNumbersSTDEVwithDuplicatesTest extends CDRTest {
    @Test
    public void calculateNumbersSTDEVwithDuplicates() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("B3:G17")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1, 2, 3)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, STDEV),
                        new MergedColumn(2, CALCULATE_NUMBERS, STDEV),
                        new MergedColumn(3, CALCULATE_NUMBERS, STDEV))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_050_calculateNumbersSTDEVwithDuplicates.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
