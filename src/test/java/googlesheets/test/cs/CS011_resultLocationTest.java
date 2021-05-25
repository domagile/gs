package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import org.junit.Test;

public class CS011_resultLocationTest extends CSTest {
    @Test
    public void resultsToNewSpreadsheet() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .considerTableHeaders(true)
                .separateByBlankRow(true)
                .resultLocation(ResultLocation.NEW_SPREADSHEET).build();
        ResultInfo resultInfo = execute(options);
        checkNewSpreadsheetResult(resultInfo);
    }
}
