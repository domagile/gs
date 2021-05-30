package googlesheets.service.process.multiplevlookupmatches;

import googlesheets.service.generic.addon.AddonRunner;

public class MultipleVlookupMatchesRunner extends AddonRunner {
    private static final String POWER_TOOLS_SECTION_ICON_ID = "imageDataTab";
    private static final String POWER_TOOLS_ADDON_ICON_ID = "power-tools-multiple-vlookup";
    private static final String GROUP_MENU_TEXT = "Multiple VLOOKUP Matches";
    private static final String LAST_MENU_TEXT = "Start";


    public MultipleVlookupMatchesRunner() {
        super(POWER_TOOLS_SECTION_ICON_ID, POWER_TOOLS_ADDON_ICON_ID, GROUP_MENU_TEXT, LAST_MENU_TEXT);
    }
}
