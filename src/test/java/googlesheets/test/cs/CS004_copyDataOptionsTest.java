package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.Test;

public class CS004_copyDataOptionsTest extends CSTest {
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
