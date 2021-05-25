package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.VAR;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR054_calculateNumbersVARwithDuplicatesTest extends CDRTest {
    @Test
    public void calculateNumbersVARwithDuplicates() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:H17")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1, 2, 3)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, VAR),
                        new MergedColumn(2, CALCULATE_NUMBERS, VAR),
                        new MergedColumn(3, CALCULATE_NUMBERS, VAR))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_054_calculateNumbersVARwithDuplicates.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
