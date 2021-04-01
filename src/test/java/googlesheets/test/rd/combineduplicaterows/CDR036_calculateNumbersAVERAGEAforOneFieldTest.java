package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.AVERAGE;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.AVERAGEA;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR036_calculateNumbersAVERAGEAforOneFieldTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1qmz0jarUCAgNgVJgT6uJ5HabJUmJwqmNSr3yEa_b6KM/edit#gid=1614810476");
    }

    @Test
    public void calculateNumbersAVERAGEAforOneField() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F8")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, AVERAGEA))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_036_calculateNumbersAVERAGEAforOneField.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
