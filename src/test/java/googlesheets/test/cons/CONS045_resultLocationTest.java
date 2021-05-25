package googlesheets.test.cons;

import googlesheets.model.consolidatesheets.ConsolidateSheetsOptionBuilder;
import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import org.junit.Test;

import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.SUM;
import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_LABEL;

public class CONS045_resultLocationTest extends CONSTest {
    @Test
    public void resultsToNewSpreadsheet() {
        ConsolidateSheetsOptions options = new ConsolidateSheetsOptionBuilder()
                .consolidatedSheets(1, 2, 3)
                .consolidationFunction(SUM)
                .consolidationType(BY_LABEL)
                .useLeftColumnLabel(true)
                .resultLocation(ResultLocation.NEW_SPREADSHEET)
                .build();
        ResultInfo resultInfo = execute(options);
        checkNewSpreadsheetResult(resultInfo);
    }
}
