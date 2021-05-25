package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.Test;

public class CS002_copyDataOptionsTest extends CSTest {
    @Test
    public void considerTableHeadersSelected()
    {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .considerTableHeaders(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        execute(options);
        checkResult();
    }
}
