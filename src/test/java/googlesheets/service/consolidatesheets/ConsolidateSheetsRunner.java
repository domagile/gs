package googlesheets.service.consolidatesheets;

import googlesheets.service.generic.addon.AddonRunner;

public class ConsolidateSheetsRunner extends AddonRunner {
    private static final String POWER_TOOLS_SECTION_ICON_ID = "mergeTab";
    private static final String POWER_TOOLS_ADDON_ICON_ID = "power-tools-data-consolidate-sheets";
    private static final String GROUP_MENU_TEXT = "Consolidate Sheets";
    private static final String LAST_MENU_TEXT = "Start";


    public ConsolidateSheetsRunner() {
        super(POWER_TOOLS_SECTION_ICON_ID, POWER_TOOLS_ADDON_ICON_ID, GROUP_MENU_TEXT, LAST_MENU_TEXT);
    }
}
