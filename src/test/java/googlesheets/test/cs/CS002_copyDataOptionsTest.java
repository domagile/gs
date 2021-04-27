package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS002_copyDataOptionsTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1nWvEsUCoccfw1a81959wbi8gCuXH3JR38zMXjNYZXXQ/edit#gid=192334885");
    }

    @Test
    public void considerTableHeadersSelected()
    {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .considerTableHeaders(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        execute(options);

        checkResult("CS_002_considerTableHeaders.csv");
    }
}
