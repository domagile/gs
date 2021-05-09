package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class CS037_oneRowTableHeaderFormulaTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
       openDocument("https://docs.google.com/spreadsheets/d/1zY5y2VrmAK4XrqTqQK1gSXYfI6hc0gYfZ-mVNUt2t0o/edit#gid=192334885");
    }

    @Ignore // don't work CS with this test
    @Test
    public void oneRowTable() {
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
