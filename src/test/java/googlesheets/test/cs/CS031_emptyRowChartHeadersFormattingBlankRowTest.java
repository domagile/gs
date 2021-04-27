package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS031_emptyRowChartHeadersFormattingBlankRowTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1VNlB8jEqnBpCvlgBGB_6NjxK8tgY0j1CawC9_JxMmYU/edit#gid=192334885");
    }

    @Test
    public void emptyRowChartHeadersFormattingBlankRow() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2)
                .considerTableHeaders(true)
                .preserveFormatting(true)
                .separateByBlankRow(true)
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkExcelResult();
    }
}
