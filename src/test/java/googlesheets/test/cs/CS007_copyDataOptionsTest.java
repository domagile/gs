package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS007_copyDataOptionsTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1UJRaDCr0OHXA-rF2Q87WA8GdFWC5RwzhZvdT5l_F9wA/edit#gid=192334885");
    }

    @Test
    public void considerHeadersAndSeparateByBlankRow()
    {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .considerTableHeaders(true)
                .separateByBlankRow(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        execute(options);
        checkResult("CS_007_considerHeadersAndSeparateByBlankRow.csv");
    }
}
