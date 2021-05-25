package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.model.generic.sheetselection.SheetSelection;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;
import org.junit.Test;

public class CS032_sheetSelectionTest extends CSTest {
    @Test
    public void spreadsheetFromDiskWithRange() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .driveSheets("CS_file1")
                .combinedSpreadsheets(new SpreadsheetSelection("CS_032", 1, 2),
                        new SpreadsheetSelection("CS_file1", new SheetSelection(2, "F8:J12")))
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkResult();
    }
}
