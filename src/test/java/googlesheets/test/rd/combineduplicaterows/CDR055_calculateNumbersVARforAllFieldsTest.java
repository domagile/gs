package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.STDEVP;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.VAR;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR055_calculateNumbersVARforAllFieldsTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1ic9XIKDZwNYeU4NJGExONUcyn-ZLtwGiK7vv8HSgudc/edit#gid=1794749578");
    }

    @Test
    public void calculateNumbersVARforAllFields() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("A1:K9")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, VAR),
                        new MergedColumn(2, CALCULATE_NUMBERS, VAR),
                        new MergedColumn(3, CALCULATE_NUMBERS, VAR),
                        new MergedColumn(4, CALCULATE_NUMBERS, VAR),
                        new MergedColumn(5, CALCULATE_NUMBERS, VAR),
                        new MergedColumn(6, CALCULATE_NUMBERS, VAR),
                        new MergedColumn(7, CALCULATE_NUMBERS, VAR),
                        new MergedColumn(8, CALCULATE_NUMBERS, VAR),
                        new MergedColumn(9, CALCULATE_NUMBERS, VAR),
                        new MergedColumn(10, CALCULATE_NUMBERS, VAR))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_055_calculateNumbersVARforAllFields.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
