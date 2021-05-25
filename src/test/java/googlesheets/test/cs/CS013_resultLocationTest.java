package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.Ignore;
import org.junit.Test;

import static googlesheets.service.combinesheets.CombineSheetsService.*;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public class CS013_resultLocationTest extends CSTest {
    @Ignore
    @Test
    public void customLocationDialogInput() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .resultLocation(ResultLocation.CUSTOM_LOCATION)
                .build();
        execute(options);
        checkResult();
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
