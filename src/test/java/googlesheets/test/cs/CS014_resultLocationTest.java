package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.Test;

import static googlesheets.service.combinesheets.CombineSheetsService.chooseStoreToCustomLocation;
import static googlesheets.service.generic.addon.GenericAddonService.setNameBoxValue;
import static googlesheets.service.generic.addon.GenericAddonService.switchDriverToAddonIframe;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.makeSheetActive;
import static googlesheets.service.generic.webdriver.WebDriverService.switchDriverToDefaultContent;
import static googlesheets.ui.components.ResultLocationPanel.clickCustomLocationValueField;

public class CS014_resultLocationTest extends CSTest {
    @Test
    public void customLocationManualSelection() {
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
