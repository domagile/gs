package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS030_emptyRowHeadersFormattingBlankRowTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1ar9tT2Kth2LmUS23_e5ek2BmvdB0p5e8pu7aCnTvxwY/edit#gid=192334885");
    }

    @Test
    public void emptyRowHeadersFormattingBlankRow() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .considerTableHeaders(true)
                .preserveFormatting(true)
                .separateByBlankRow(true)
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkExcelResult("CS_030_emptyRowHeadersFormattingBlankRow.xlsx");
    }
}
