package googlesheets.service.mergesheets;

import googlesheets.service.generic.addon.AddonRunner;

public class MergeSheetsRunner extends AddonRunner {
    private static final String POWER_TOOLS_SECTION_ICON_ID = "imageMergeTab";
    private static final String POWER_TOOLS_ADDON_ICON_ID = "power-tools-merge-sheets";
    private static final String GROUP_MENU_TEXT = "Merge Sheets";
    private static final String LAST_MENU_TEXT = "Start";


    public MergeSheetsRunner() {
        super(POWER_TOOLS_SECTION_ICON_ID, POWER_TOOLS_ADDON_ICON_ID, GROUP_MENU_TEXT, LAST_MENU_TEXT);
    }
}
