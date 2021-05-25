package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.Test;

public class CS030_emptyRowHeadersFormattingBlankRowTest extends CSTest {
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
        checkExcelResult();
    }
}
