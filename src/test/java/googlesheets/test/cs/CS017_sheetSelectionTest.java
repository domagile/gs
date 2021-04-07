package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS017_sheetSelectionTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1-wsjCON7BXJPjI0i8ENJPsaRb_fo92shsLyG1qd2Q6c/edit#gid=192334885");
    }

    @Test
    public void twoSpreadsheets() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .driveSheets("CS_file1")
                .combinedSpreadsheets(new SpreadsheetSelection("CS_017", 2),
                        new SpreadsheetSelection("CS_file1", 1))
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkResult("CS_017_twoSpreadsheets.csv");
    }
}
