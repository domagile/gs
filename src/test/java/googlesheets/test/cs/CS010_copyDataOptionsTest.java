package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public class CS010_copyDataOptionsTest extends CSTest {
    @Test
    public void considerHeadersAndUseFormula()
    {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .considerTableHeaders(true)
                .useFormula(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        execute(options);
        sleep(5000);
        checkResult();
    }
}
