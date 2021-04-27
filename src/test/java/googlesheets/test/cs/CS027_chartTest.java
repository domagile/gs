package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS027_chartTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/12JH565pMRa20H5NKUoN8Q2wG0MFcTOtHI8ju92StYjA/edit#gid=192334885");
    }

    @Test
    public void chart() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2)
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkResult();
    }
}
