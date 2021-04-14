package googlesheets.test.cons;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.consolidatesheets.ConsolidateSheetsOptionBuilder;
import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.test.cs.CSTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration.SUM;
import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_LABEL;
import static googlesheets.service.combinesheets.CombineSheetsService.chooseStoreToCustomLocation;
import static googlesheets.service.generic.addon.GenericAddonService.*;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.generic.google.GoogleSheetService.makeSheetActive;
import static googlesheets.ui.components.ResultLocationPanel.clickCustomLocationValueField;

public class CONS046_resultLocationTest extends CONSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1EzHF8qGr5QGgcN-x6AqXTYte7RaM-R8DqnFM4ML6OnY/edit#gid=795301200");
    }

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
