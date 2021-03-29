package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS009_copyDataOptionsTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1CB-_Z26ROucycWvFtM-2IKjWaigAldoetkPQ3FqTwuY/edit#gid=192334885");
    }

    @Test
    public void considerTableHeadersPreserveFormattingSeparateByBlankRow()
    {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .considerTableHeaders(true)
                .separateByBlankRow(true)
                .preserveFormatting(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        execute(options);
        checkExcelResult("Combined data", "CS_009_considerTableHeadersPreserveFormattingSeparateByBlankRow.xlsx");
    }
}
