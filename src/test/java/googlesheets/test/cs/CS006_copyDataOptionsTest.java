package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS006_copyDataOptionsTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1uj7DFm74xkw4SrXG_sBVgCsDODAm63B4qF7skfHCpiQ/edit#gid=192334885");
    }

    @Test
    public void considerTableHeadersAndPreserveFormatting()
    {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .considerTableHeaders(true)
                .preserveFormatting(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        execute(options);
        checkExcelResult("CS_006_considerTableHeadersAndPreserveFormatting.xlsx");
    }
}
