package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.Test;

public class CS031_emptyRowChartHeadersFormattingBlankRowTest extends CSTest {
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
