package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.MODE;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.PRODUCT;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR047_calculateNumbersMODEwithDuplicatesTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1wBzV3-pJLWykdSxkSCXwn53mpRjrFsFMuqLoQOsrsG8/edit#gid=1608639482");
    }

    @Test
    public void calculateNumbersMODEwithDuplicates() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:H17")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1, 2, 3)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, MODE),
                        new MergedColumn(2, CALCULATE_NUMBERS, MODE),
                        new MergedColumn(3, CALCULATE_NUMBERS, MODE))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_047_calculateNumbersMODEwithDuplicates.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
