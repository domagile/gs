package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS029_chartConsiderHeadersUseFormulaTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1znSKO30batEbWA3p4QUrFnrs3Rn6z-wj6Zq6fqTTxVI/edit#gid=192334885");
    }

    @Test
    public void chartConsiderHeadersUseFormula() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2)
                .considerTableHeaders(true)
                .useFormula(true)
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkResult("CS_029_chartConsiderHeadersUseFormula.csv");
    }
}
