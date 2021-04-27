package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS028_chartConsiderHeadersTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1MGYfDYekwCp_WV0ILuaCtFmLgceKjOf5c82AEnBN6J4/edit#gid=192334885");
    }

    @Test
    public void chartConsiderHeaders() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2)
                .considerTableHeaders(true)
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkResult("CS_028_chartConsiderHeaders.csv");
    }
}
