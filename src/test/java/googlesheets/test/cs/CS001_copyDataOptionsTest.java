package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS001_copyDataOptionsTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1h2A6USsz0s4h311-oVnU7r3gOEyEUAQiwEHrNAxHETs/edit#gid=192334885");
    }

    @Test
    public void copyDataOptionsDeselected()
    {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        execute(options);
        checkResult("Combined data", "CS_001_copyDataOptionsDeselected.csv");
    }
}
