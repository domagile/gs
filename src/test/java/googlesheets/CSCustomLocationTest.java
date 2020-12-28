package googlesheets;

import googlesheets.service.GoogleSheetService;
import googlesheets.service.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.service.combinesheets.CombineSheetsOptions;
import googlesheets.service.combinesheets.ResultLocation;
import googlesheets.test.SpreadsheetTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.GoogleSheetService.duplicateListThroughMenu;
import static googlesheets.service.combinesheets.CombineSheetsService.*;

public class CSCustomLocationTest extends SpreadsheetTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1jwvnvadr1sgQQCvetLFB0qWYfwrTFFGfvMHIoyEgXqM/edit");
    }


    @Override
    protected String getSpreadsheetName() {
        return "CS_CustomLocation";
    }

    @Test
    public void combineToCustomLocation() throws IOException, InterruptedException {
        duplicateListThroughMenu("Sheet2_auto");
        runCombineSheets();
        selectSheetsToCombine(1, 2);

        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .considerTableHeaders(true)
                .resultLocation(ResultLocation.CUSTOM_LOCATION)
                .locationValue("Copy of Sheet2_auto!C15").build();
        selectAdditionalOptions(options);

        clickCombineAndClose();
        checkResult("Copy of Sheet2_auto", "cs_customlocation.csv");
    }
}
