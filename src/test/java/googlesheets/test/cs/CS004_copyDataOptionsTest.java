package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS004_copyDataOptionsTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1YSdhdWb4unbJArpLhoiKBJ0zMNBGIQZkNWBa6B66HoI/edit#gid=192334885");
    }

    @Test
    public void preserveFormattingSelected()
    {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .preserveFormatting(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        execute(options);
        checkExcelResult();
    }
}
