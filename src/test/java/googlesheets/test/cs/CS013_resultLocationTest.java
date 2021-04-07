package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static googlesheets.service.combinesheets.CombineSheetsService.*;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public class CS013_resultLocationTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1Ro4gL72_71hfJvN8ouOYWtM6nPJtyBaVapDT0W-M9j0/edit#gid=192334885");
    }

    @Ignore
    @Test
    public void customLocationDialogInput() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .resultLocation(ResultLocation.CUSTOM_LOCATION)
                .build();
        execute(options);
        checkResult("CS_013_customLocationDialogInput.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(3);
    }


    @Override
    protected String getUpdatedSheetName() {
        return "Table1";
    }


    @Override
    protected void selectResultLocation(CombineSheetsOptions options) {
        chooseStoreToCustomLocation();
        sleep(1000);
        clickCustomLocationDialogButton();
        setCustomLocationValueOnLocationDialog("B15");
        clickOKOnLocationDialog();
    }
}
