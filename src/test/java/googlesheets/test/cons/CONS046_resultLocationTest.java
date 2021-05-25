package googlesheets.test.cons;

import googlesheets.model.consolidatesheets.ConsolidateSheetsOptionBuilder;
import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import org.junit.Test;

import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.SUM;
import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_LABEL;
import static googlesheets.service.combinesheets.CombineSheetsService.chooseStoreToCustomLocation;
import static googlesheets.service.generic.addon.GenericAddonService.setNameBoxValue;
import static googlesheets.service.generic.addon.GenericAddonService.switchDriverToAddonIframe;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.makeSheetActive;
import static googlesheets.service.generic.webdriver.WebDriverService.switchDriverToDefaultContent;
import static googlesheets.ui.components.ResultLocationPanel.clickCustomLocationValueField;

public class CONS046_resultLocationTest extends CONSTest {
    @Test
    public void customLocationManualSelection() {
        ConsolidateSheetsOptions options = new ConsolidateSheetsOptionBuilder()
                .consolidatedSheets(1, 2, 3)
                .consolidationFunction(SUM)
                .consolidationType(BY_LABEL)
                .useLeftColumnLabel(true)
                .resultLocation(ResultLocation.CUSTOM_LOCATION)
                .build();

        execute(options);
        checkResult();
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(1);
    }


    @Override
    protected String getUpdatedSheetName() {
        return "Table2";
    }


    @Override
    protected void selectResultLocation(ConsolidateSheetsOptions options) {
        chooseStoreToCustomLocation();
        switchDriverToDefaultContent();
        makeSheetActive("Table2");
        String customLocationValue = "T8";
        setNameBoxValue(customLocationValue);
        switchDriverToAddonIframe();
        clickCustomLocationValueField();
    }
}
