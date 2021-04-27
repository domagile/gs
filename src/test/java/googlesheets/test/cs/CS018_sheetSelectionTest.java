package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.model.generic.sheetselection.SheetSelection;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS018_sheetSelectionTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1sq2TcIawQTO8NS-gfYjtOIbJyvL18TGoTeRtwaCTCvk/edit#gid=192334885");
    }

    @Test
    public void secondSheetWithRange() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(new SheetSelection(1),
                        new SheetSelection(2, "D3:H8"))
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkResult();
    }
}
