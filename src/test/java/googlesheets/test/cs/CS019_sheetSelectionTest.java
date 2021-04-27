package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.model.generic.sheetselection.SheetSelection;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS019_sheetSelectionTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1I3bXuz4NeikBmPqzcDbmgXGjTZJ7EqpdFyc48xnyHz0/edit#gid=192334885");
    }

    @Test
    public void twoSheetsWithRange() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(new SheetSelection(1, "F5:J10"),
                        new SheetSelection(2, "D3:H8"))
                .considerTableHeaders(true)
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkResult();
    }
}
