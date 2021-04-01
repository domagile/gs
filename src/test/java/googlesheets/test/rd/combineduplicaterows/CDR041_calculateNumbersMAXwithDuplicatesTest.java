package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.MAX;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.MIN;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR041_calculateNumbersMAXwithDuplicatesTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1F8kPM3WgW8pPTJkIjq3_LUYwQRY054O4SOY1khOvA2w/edit#gid=1261613010");
    }

    @Test
    public void calculateNumbersMAXwithDuplicates() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:H17")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1, 2, 3)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, MAX),
                        new MergedColumn(2, CALCULATE_NUMBERS, MAX),
                        new MergedColumn(3, CALCULATE_NUMBERS, MAX))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_041_calculateNumbersMAXwithDuplicates.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
