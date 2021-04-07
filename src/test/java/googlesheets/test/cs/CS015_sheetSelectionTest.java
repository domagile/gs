package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.combinesheets.CombineSheetsService.chooseStoreToCustomLocation;
import static googlesheets.service.combinesheets.CombineSheetsService.clickCustomLocationValueField;
import static googlesheets.service.generic.addon.GenericAddonService.*;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.makeSheetActive;

public class CS015_sheetSelectionTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1DLux6KLyUPiiIKcPDr3zWDZALOhq5fJ06eUV-mR-hxU/edit#gid=192334885");
    }

    @Test
    public void twoSheetsFromThree() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 3)
                .resultLocation(ResultLocation.NEW_SHEET)
                .build();
        execute(options);
        checkResult("CS_015_twoSheetsFromThree.csv");
    }
}
