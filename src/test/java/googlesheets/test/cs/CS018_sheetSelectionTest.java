package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.model.generic.sheetselection.SheetSelection;
import org.junit.Test;

public class CS018_sheetSelectionTest extends CSTest {
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
