package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.service.generic.addon.ResultInfo;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS011_resultLocationTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1lyKZDeKJRLyWvEjuFcm4AiOjYQ_wk9aybuH_XB86MwQ/edit#gid=192334885");
    }

    @Test
    public void resultsToNewSpreadsheet() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .considerTableHeaders(true)
                .separateByBlankRow(true)
                .resultLocation(ResultLocation.NEW_SPREADSHEET).build();
        ResultInfo resultInfo = execute(options);
        checkNewSpreadsheetResult("CS_011_resultsToNewSpreadsheet.csv", resultInfo);
    }
}
