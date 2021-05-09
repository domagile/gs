package googlesheets.test.cons;

import googlesheets.model.consolidatesheets.ConsolidateSheetsOptionBuilder;
import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.SUM;
import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_LABEL;
import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public class CONS048_sheetSelectionTest extends CONSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1r0m1x6cHaszLn3xyzP4aXXIfkG9zML4QoHb6PcP8wuk/edit#gid=795301200");
    }

    @Test
    public void consolidate()
    {
        ConsolidateSheetsOptions options = new ConsolidateSheetsOptionBuilder()
                .driveSheets("CONS_file1")
                .consolidatedSpreadsheets(new SpreadsheetSelection("CONS_048", 2),
                        new SpreadsheetSelection("CONS_file1", 1))
                .consolidationFunction(SUM)
                .consolidationType(BY_LABEL)
                .useLeftColumnLabel(true)
                .build();
        execute(options);
        sleep(500);
        checkResult();
    }
}
