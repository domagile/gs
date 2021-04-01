package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.STDEV;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.STDEVP;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR053_calculateNumbersSTDEVPforAllFieldsTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1YjPoPwcBfCdXfzra_rf7lxAOcT-8icE18rIDKO_-yR8/edit#gid=1880342461");
    }

    @Test
    public void calculateNumbersSTDEVPforAllFields() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("A1:K9")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, STDEVP),
                        new MergedColumn(2, CALCULATE_NUMBERS, STDEVP),
                        new MergedColumn(3, CALCULATE_NUMBERS, STDEVP),
                        new MergedColumn(4, CALCULATE_NUMBERS, STDEVP),
                        new MergedColumn(5, CALCULATE_NUMBERS, STDEVP),
                        new MergedColumn(6, CALCULATE_NUMBERS, STDEVP),
                        new MergedColumn(7, CALCULATE_NUMBERS, STDEVP),
                        new MergedColumn(8, CALCULATE_NUMBERS, STDEVP),
                        new MergedColumn(9, CALCULATE_NUMBERS, STDEVP),
                        new MergedColumn(10, CALCULATE_NUMBERS, STDEVP))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_053_calculateNumbersSTDEVPforAllFields.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
