package googlesheets.service.mergevalues;

import googlesheets.model.mergevalues.MergeValuesOptions;
import googlesheets.ui.mergevalues.MergeValuesAddonDialog;

import static googlesheets.service.generic.addon.GenericAddonService.setNameBoxValue;
import static googlesheets.service.generic.addon.GenericAddonService.waitForWorkingMessageDisplayedAndHidden;

public class MergeValuesService {
    private MergeValuesAddonDialog addonDialog = new MergeValuesAddonDialog();

    public void runMergeValues()
    {
        new MergeValuesRunner().runAddon();
    }


    public void selectRange(String range) {
        setNameBoxValue(range);
    }


    public void setOptions(MergeValuesOptions options) {
        addonDialog.setMergeType(options.getMergeType());
        setSeparatorToDialog(options);
        addonDialog.setResultLocation(options.getResultLocation());

        addonDialog.setMergeCellsInEachRow(options.isMergeCells());
        if (!options.isMergeCells()) {
            addonDialog.setInsertNewColumn(options.isInsertNewColumn());
            addonDialog.setClearContentsOfCells(options.isClearContentsOfCells());
        }
        addonDialog.setSkipEmptyCells(options.isSkipEmptyCells());
        addonDialog.setWrapText(options.isWrapText());
    }

    private void setSeparatorToDialog(MergeValuesOptions options) {
        if (options.getPredefinedSeparator() == null) {
            addonDialog.setCustomSeparator(options.getCustomSeparator());
        }
        else {
            addonDialog.setPredefinedSeparator(options.getPredefinedSeparator());
        }
    }


    public void merge() {
        addonDialog.clickMerge();
        waitForWorkingMessageDisplayedAndHidden();
    }
}

