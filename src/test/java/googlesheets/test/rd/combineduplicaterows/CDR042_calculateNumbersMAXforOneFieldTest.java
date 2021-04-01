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


public class CDR042_calculateNumbersMAXforOneFieldTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1mL97LQG6JrM-GpqVLdYMg1y7YKZYIMOxfPz6JKdL3iE/edit#gid=460565208");
    }

    @Test
    public void calculateNumbersMAXforOneField() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F8")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, MAX))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_042_calculateNumbersMAXforOneField.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
