package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS024_emptyRowConsiderTableHeadersTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1_4z3s_8-7JaXaA2CekUsGA88PRFFc2md-Qynj81cdk4/edit#gid=192334885");
    }

    @Test
    public void emptyRowConsiderTableHeaders() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .considerTableHeaders(true)
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkResult("CS_024_emptyRowConsiderTableHeaders.csv");
    }
}
