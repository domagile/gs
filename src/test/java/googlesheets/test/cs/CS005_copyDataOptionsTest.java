package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS005_copyDataOptionsTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1JwbUz9wf8QRS7VDxlCuInniReOm3YTPFjWvliWWgMbw/edit#gid=192334885");
    }

    @Test
    public void separateByBlankRowSelected()
    {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .separateByBlankRow(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        execute(options);
        checkResult("CS_005_separateByBlankRow.csv");
    }
}
