package googlesheets.service.consolidatesheets;

import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import googlesheets.model.generic.sheetselection.SheetSelectionProvider;
import googlesheets.ui.components.SheetSelectionPanel;
import googlesheets.ui.consolidatesheets.ConsolidateSheetsAddonDialog;

import static googlesheets.service.generic.addon.GenericAddonService.waitForCompletionAndClose;
import static googlesheets.ui.consolidatesheets.ConsolidateSheetsAddonDialog.BUTTON_ID_CLOSE;

public class ConsolidateSheetsService {
    private ConsolidateSheetsAddonDialog addonDialog = new ConsolidateSheetsAddonDialog();



    public void selectConsolidationOptions(ConsolidateSheetsOptions options) {
        addonDialog.setConsolidationFunction(options.getConsolidationFunction());
        addonDialog.setConsolidationType(options.getConsolidationType());
        addonDialog.setUseHeaderLabel(options.isUseHeaderLabel());
        addonDialog.setUseLeftColumnLabel(options.isUseLeftColumnLabel());
    }


    public void selectSheetsToConsolidate(SheetSelectionProvider selectionProvider)
    {
        SheetSelectionPanel selectionPanel = addonDialog.getSheetSelectionPanel();
        selectionPanel.selectSheets(selectionProvider);
    }


    public void clickConsolidateAndClose() {
        addonDialog.clickConsolidate();
        waitForCompletionAndClose("have been successfully consolidated", BUTTON_ID_CLOSE);
    }


    public void selectUseFormulaOption(ConsolidateSheetsOptions options)
    {
        addonDialog.setUseFormulaToConsolidateSheets(options.isUseFormula());
    }


    public void selectResultLocation(ConsolidateSheetsOptions options) {
        addonDialog.getResultLocationPanel()
                .selectResultLocation(options.getResultLocation(), options.getCustomLocationValue());
    }


    public void clickNext()
    {
        addonDialog.clickNext();
    }


    public void clickConsolidate()
    {
        clickNext();
    }
}

