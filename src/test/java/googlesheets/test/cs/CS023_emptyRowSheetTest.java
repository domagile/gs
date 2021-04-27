package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

public class CS023_emptyRowSheetTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1g7_PMNfbiFaGpZefd_G5TnrSnGREGe7dJSm88FByEFY/edit#gid=192334885");
    }

    @Test
    public void emptyRowSheet() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkResult();
    }
}
