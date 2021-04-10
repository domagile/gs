package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS026_emptyRowFromDriveWithHeadersFormulaTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1t4GwzhzzBXx1kkM4VxO5wjkxv5jbYu-3KWg7HB8txE0/edit#gid=192334885");
    }

    @Test
    public void emptyRowFromDriveWithHeadersFormula() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .driveSheets("CS_oneEmptyRow")
                .combinedSpreadsheets(new SpreadsheetSelection("CS_026", 1, 2),
                        new SpreadsheetSelection("CS_oneEmptyRow", 1))
                .considerTableHeaders(true)
                .useFormula(true)
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkResult("CS_026_emptyRowFromDriveWithHeadersFormula.csv");
    }
}
