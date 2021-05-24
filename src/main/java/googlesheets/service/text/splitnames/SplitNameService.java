package googlesheets.service.text.splitnames;

import googlesheets.model.text.splitnames.SplitNameOptions;
import googlesheets.service.generic.addon.SideAddonService;
import googlesheets.ui.text.splitnames.SplitNameDialog;

import static googlesheets.service.generic.addon.GenericAddonService.setNameBoxValue;
import static googlesheets.service.generic.addon.GenericAddonService.waitForWorkingMessageDisplayedAndHidden;

public class SplitNameService implements SideAddonService<SplitNameOptions> {
    private SplitNameDialog addonDialog = new SplitNameDialog();

    @Override
    public void selectRange(String range) {
        setNameBoxValue(range);
    }


    @Override
    public void runAddon() {
        new SplitNameRunner().runAddon();
    }

    @Override
    public void setOptions(SplitNameOptions options) {
        addonDialog.setColumnHasHeader(options.isColumnHasHeader());
        addonDialog.setFirstName(options.isFirstName());
        addonDialog.setMiddleName(options.isMiddleName());
        addonDialog.setLastName(options.isLastName());
        addonDialog.setSalutationTitle(options.isSalutationTitle());
        addonDialog.setNameSuffix(options.isNameSuffix());
    }


    @Override
    public void execute() {
        addonDialog.clickSplitButton();
        waitForWorkingMessageDisplayedAndHidden();
    }
}
