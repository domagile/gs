package googlesheets.service.removeduplicates.quickdedupe;

import googlesheets.service.removeduplicates.generic.RemoveDuplicatesRunner;

public class QuickDedupeRunner extends RemoveDuplicatesRunner {
    private static final String MENU_TEXT_QUICK_DEDUPE = "Quick dedupe";
    private static final String POWER_TOOLS_ADDON_ICON_ID = "power-tools-data-quick-dedupe-table";

    public QuickDedupeRunner() {
        super(POWER_TOOLS_ADDON_ICON_ID, MENU_TEXT_QUICK_DEDUPE);
    }




}
