package googlesheets.test.cons;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.consolidatesheets.ConsolidateSheetsOptionBuilder;
import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.service.generic.addon.ResultInfo;
import googlesheets.test.cs.CSTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.SUM;
import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.VARP;
import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_LABEL;
import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_POSITION;

public class CONS045_resultLocationTest extends CONSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/17xizbRmSmy4-fqbvhwzFBYLTl2aQUx-tQJOu05L_ZDA/edit#gid=795301200");
    }

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
