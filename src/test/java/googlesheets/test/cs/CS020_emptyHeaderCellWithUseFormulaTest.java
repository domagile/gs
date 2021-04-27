package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.model.generic.sheetselection.SheetSelection;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS020_emptyHeaderCellWithUseFormulaTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
       // openDocument("https://docs.google.com/spreadsheets/d/1JzoGTyLwX5OjJkTpR5DEdH771iS0MA6Ez_C-oO6_kp4/edit#gid=192334885");
        openDocument("https://docs.google.com/spreadsheets/d/1o5kj0dFIb0KJrw8wwYhmf-W2McXd1alVb7vrUnb-Cuo/edit#gid=192334885");
    }

    @Test
    public void emptyHeaderCellWithUseFormula() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .considerTableHeaders(true)
                .useFormula(true)
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkResult();
    }
}
