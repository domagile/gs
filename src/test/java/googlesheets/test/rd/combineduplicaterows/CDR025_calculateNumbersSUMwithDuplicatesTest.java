package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.SUM;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR025_calculateNumbersSUMwithDuplicatesTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/18JWGNAi787LUujaRETGwpdQYmW1dLJm0DijdR-TNT84/edit#gid=1751487197");
    }

    @Test
    public void calculateNumbersSUMwithDuplicates() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:H17")
                .dataHasHeaderRow(true)
                .matchCase(true)
                .keyColumnIndexes(1, 2, 3)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, SUM),
                        new MergedColumn(2, CALCULATE_NUMBERS, SUM),
                        new MergedColumn(3, CALCULATE_NUMBERS, SUM))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_025_calculateNumbersSUMwithDuplicates.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
