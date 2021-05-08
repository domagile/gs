package googlesheets.service.text.add;

import googlesheets.model.text.add.AddTextOptions;
import googlesheets.service.generic.addon.SideAddonService;
import googlesheets.ui.text.add.AddTextDialog;

import static googlesheets.service.generic.addon.GenericAddonService.setNameBoxValue;
import static googlesheets.service.generic.addon.GenericAddonService.waitForWorkingMessageDisplayedAndHidden;

public class AddTextService implements SideAddonService<AddTextOptions> {
    private AddTextDialog addonDialog = new AddTextDialog();

    public void runAddon()
    {
        new AddTextRunner().runAddon();
    }


    public void selectRange(String range) {
        setNameBoxValue(range);
    }


    public void setOptions(AddTextOptions options) {
        addonDialog.setAddedText(options.getAddedText());
        addonDialog.setPosition(options);
        addonDialog.setSkipEmptyCells(options.isSkipEmptyCells());
    }


    public void execute() {
        addonDialog.clickRun();
        waitForWorkingMessageDisplayedAndHidden();
    }
}
