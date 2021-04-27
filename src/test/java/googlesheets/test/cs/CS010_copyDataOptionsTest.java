package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public class CS010_copyDataOptionsTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        // openDocument("https://docs.google.com/spreadsheets/d/10phM96AxtKxye6YN3ydjCDMhixmKxof_xJ7rd6Si_TE/edit#gid=192334885");
        openDocument("https://docs.google.com/spreadsheets/d/12lvo4umtbn-EIsvwq2oDbDPuw3h6YJ0Kkx2OzXEfwkU/edit#gid=192334885");
    }

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
