package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public class CS003_copyDataOptionsTest extends CSTest {
    @Test
    public void useFormulaSelected()
    {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .useFormula(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        execute(options);
        sleep(5000);
        checkResult();
    }
}
