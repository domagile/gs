package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.AVERAGE;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.SUM;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR032_calculateNumbersAVERAGEwithDuplicatesTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1khZAlOnQs46KJGQlhIipLd_bgYaqf-hsmr8e1bEQuZU/edit#gid=123235051");
    }

    @Test
    public void calculateNumbersAVERAGEwithDuplicates() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:H17")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1, 2, 3)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, AVERAGE),
                        new MergedColumn(2, CALCULATE_NUMBERS, AVERAGE),
                        new MergedColumn(3, CALCULATE_NUMBERS, AVERAGE))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_032_calculateNumbersAVERAGEwithDuplicates.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
