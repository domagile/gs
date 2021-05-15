package googlesheets.service.process.functionbycolor;

import googlesheets.model.process.functionbycolor.FunctionByColorOptions;
import googlesheets.service.generic.addon.SideAddonService;
import googlesheets.ui.process.functionbycolor.FunctionByColorDialog;

import static googlesheets.service.generic.addon.GenericAddonService.waitForWorkingMessageDisplayedAndHidden;

public class FunctionByColorService implements SideAddonService<FunctionByColorOptions> {
    private FunctionByColorDialog addonDialog = new FunctionByColorDialog();

    @Override
    public void selectRange(String range) {
    }

    @Override
    public void runAddon() {
        new FunctionByColorRunner().runAddon();
    }

    @Override
    public void setOptions(FunctionByColorOptions options) {
        addonDialog.setRange(options.getRange());
        if (options.getColorCell() != null) {
            addonDialog.clickPatternCellIcon();
            addonDialog.setColorCell(options.getColorCell());
        }
        addonDialog.setFontColorOption(options.isFontColorOption());
        if (options.isFontColorOption() && options.getFontColorValue() != null) {
            addonDialog.setFontColorValue(options.getFontColorValue());
        }
        addonDialog.setBackgroundColorOption(options.isBackgroundColorOption());
        if (options.isBackgroundColorOption() && options.getBackgroundColorValue() != null) {
            addonDialog.setBackgroundColorValue(options.getBackgroundColorValue());
        }
        addonDialog.setFunction(options.getFunction());
        addonDialog.setResultRange(options.getResultRange());
        addonDialog.expandHiddenOptions();
        addonDialog.setCalculationMode(options.getCalculationMode());
        addonDialog.setFillResultsWithColors(options.isFillResultsWithColors());
    }

    @Override
    public void execute() {
        addonDialog.clickInsertFunctionButton();
        waitForWorkingMessageDisplayedAndHidden();
    }
}
