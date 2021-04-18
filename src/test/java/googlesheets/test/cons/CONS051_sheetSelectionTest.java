package googlesheets.test.cons;

import googlesheets.model.consolidatesheets.ConsolidateSheetsOptionBuilder;
import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import googlesheets.model.generic.sheetselection.SheetSelection;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.SUM;
import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_LABEL;

public class CONS051_sheetSelectionTest extends CONSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1QmYrhXfF0RgHX8LZFjEeguML0OoRY2-lDtYqUac_7Dg/edit#gid=795301200");
    }

    @Test
    public void consolidate()
    {
        ConsolidateSheetsOptions options = new ConsolidateSheetsOptionBuilder()
                .driveSheets("CONS_file1")
                .consolidatedSpreadsheets(new SpreadsheetSelection("CONS_051", new SheetSelection(2, "A5:K75")),
                        new SpreadsheetSelection("CONS_file1", new SheetSelection(1, "A10:J100")))
                .consolidationFunction(SUM)
                .consolidationType(BY_LABEL)
                .useLeftColumnLabel(true)
                .build();
        execute(options);
        checkResult();
    }
}
