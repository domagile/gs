package googlesheets.service.mergevalues;

import googlesheets.service.generic.addon.AddonRunner;

public class MergeValuesRunner extends AddonRunner {
    private static final String POWER_TOOLS_SECTION_ICON_ID = "imageMergeTab";
    private static final String POWER_TOOLS_ADDON_ICON_ID = "power-tools-merge-values";
    private static final String GROUP_MENU_TEXT = "Merge Values";
    private static final String LAST_MENU_TEXT = "Start";


    public MergeValuesRunner() {
        super(POWER_TOOLS_SECTION_ICON_ID, POWER_TOOLS_ADDON_ICON_ID, GROUP_MENU_TEXT, LAST_MENU_TEXT);
    }


    @Override
    protected boolean isSidePanelAddon() {
        return true;
    }
}
