package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.checkerframework.checker.units.qual.A;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.AVERAGE;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.COUNTA;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR034_calculateNumbersAVERAGEforAllFieldsTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1ksPI04O8A-oL_e1zlyTBp2czAK5w30Xaoi4P6qLoQaU/edit#gid=908214213");
    }

    @Test
    public void calculateNumbersAVERAGEforAllFields() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("A1:K9")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, AVERAGE),
                        new MergedColumn(2, CALCULATE_NUMBERS, AVERAGE),
                        new MergedColumn(3, CALCULATE_NUMBERS, AVERAGE),
                        new MergedColumn(4, CALCULATE_NUMBERS, AVERAGE),
                        new MergedColumn(5, CALCULATE_NUMBERS, AVERAGE),
                        new MergedColumn(6, CALCULATE_NUMBERS, AVERAGE),
                        new MergedColumn(7, CALCULATE_NUMBERS, AVERAGE),
                        new MergedColumn(8, CALCULATE_NUMBERS, AVERAGE),
                        new MergedColumn(9, CALCULATE_NUMBERS, AVERAGE),
                        new MergedColumn(10, CALCULATE_NUMBERS, AVERAGE))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_034_calculateNumbersAVERAGEforAllFields.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
