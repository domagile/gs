package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public class CS003_copyDataOptionsTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        // openDocument("https://docs.google.com/spreadsheets/d/1d5kcOw1Z677cJfxBsO2Wt-dNk3CHpHc4jg0K2pBB1hk/edit#gid=192334885"); переименовала имя файла
        openDocument("https://docs.google.com/spreadsheets/d/1LEFv3jcSmtipX5dxEgNAAWY304uUUtHT1CpsJ2wHVvw/edit#gid=192334885");
    }

    @Test
    public void useFormulaSelected()
    {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .useFormula(true)
                .resultLocation(ResultLocation.NEW_SHEET).build();
        execute(options);
        sleep(5000);
        checkResult("CS_003_useFormula.csv");
    }
}
