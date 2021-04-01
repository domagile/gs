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


public class CDR048_calculateNumbersMODEforOneFieldTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1VCJtUAA9vdme6hJ5FJiDUPkQ3viha-tiBrBfAoXSnpw/edit#gid=235673294");
    }

    @Test
    public void calculateNumbersMODEforOneField() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("B3:G17")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, MODE))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_048_calculateNumbersMODEforOneField.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
