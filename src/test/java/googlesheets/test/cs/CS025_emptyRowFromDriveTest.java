package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS025_emptyRowFromDriveTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1h822jCzre-QkuDV5aEpPskVCCt2FosbYMV3gof_1CAQ/edit#gid=192334885");
    }

    @Test
    public void emptyRowFromDrive() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .driveSheets("CS_oneEmptyRow")
                .combinedSpreadsheets(new SpreadsheetSelection("CS_025", 1, 2),
                        new SpreadsheetSelection("CS_oneEmptyRow", 1))
                .considerTableHeaders(true)
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkResult();
    }
}
