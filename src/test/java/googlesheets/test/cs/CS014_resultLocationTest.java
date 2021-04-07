package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.combinesheets.CombineSheetsService.*;
import static googlesheets.service.generic.addon.GenericAddonService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class CS014_resultLocationTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/18F2ZxpQWRXQu7vWjTAUTMgsIWyrQwK8QTzlrQhsK9HY/edit#gid=192334885");
    }

    @Test
    public void customLocationManualSelection() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .resultLocation(ResultLocation.CUSTOM_LOCATION)
                .build();
        execute(options);
        checkResult("CS_014_customLocationManualSelection.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(3);
    }


    @Override
    protected String getUpdatedSheetName() {
        return "Table2";
    }


    @Override
    //Test doesn't check that chosen cell is inserted immediately to custom location.
    //It should be reviewed if selection of cell without name box would be available.
    protected void selectResultLocation(CombineSheetsOptions options) {
        chooseStoreToCustomLocation();
        switchDriverToDefaultContent();
        makeSheetActive("Table2");
        String customLocationValue = "B15";
        setNameBoxValue(customLocationValue);
        switchDriverToAddonIframe();
        clickCustomLocationValueField();
    }
}
