package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS008_copyDataOptionsTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1409uV_DG5EkQf5luWWRruz6neg814DanL3rf82l5LWA/edit#gid=192334885");
    }

    @Test
    public void preserveFormattingAndSeparateByBlankRow()
    {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .separateByBlankRow(true)
                .preserveFormatting(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        execute(options);
        checkExcelResult();
    }
}
