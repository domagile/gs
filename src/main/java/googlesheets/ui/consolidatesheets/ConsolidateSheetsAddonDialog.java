package googlesheets.ui.consolidatesheets;

import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import googlesheets.model.consolidatesheets.ConsolidationFunctionEnumeration;
import googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration;
import googlesheets.ui.components.ResultLocationPanel;
import googlesheets.ui.components.SheetSelectionPanel;

import static googlesheets.model.consolidatesheets.ConsolidationTypeEnumeration.BY_POSITION;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class ConsolidateSheetsAddonDialog {
    public static final String BUTTON_ID_CONSOLIDATE = "consolidateSheetsNext";
    public static final String BUTTON_ID_CLOSE = "consolidateSheetsClose";

    private SheetSelectionPanel sheetSelectionPanel = new SheetSelectionPanel();
    private ResultLocationPanel resultLocationPanel = new ResultLocationPanel(BUTTON_ID_CONSOLIDATE);


    public void selectResultLocation(ConsolidateSheetsOptions options) {
        resultLocationPanel.selectResultLocation(options.getResultLocation(), options.getCustomLocationValue());
    }


    public void setUseFormulaToConsolidateSheets(boolean value) {
        setCheckboxValue(value, "bInsertFormula");
    }

    public void setUseHeaderLabel(boolean value) {
        setCheckboxValue(value, "checkHeaderLabel");
    }

    public void setUseLeftColumnLabel(boolean value) {
        setCheckboxValue(value, "checkColumnLabel");
    }


    public void clickConsolidate() {
        clickElement(BUTTON_ID_CONSOLIDATE);
    }


    public void clickNext() {
        clickElement(BUTTON_ID_CONSOLIDATE);
    }

    public void setConsolidationFunction(ConsolidationFunctionEnumeration function) {
        selectComboboxValue("selectConsolidateFuncList", function.getText());
    }

    public void setConsolidationType(ConsolidationTypeEnumeration type) {
        clickRadioButton(type == BY_POSITION ? "consOptionPos" : "consOptionLab");
    }

    public SheetSelectionPanel getSheetSelectionPanel() {
        return sheetSelectionPanel;
    }

    public ResultLocationPanel getResultLocationPanel() {
        return resultLocationPanel;
    }
}
