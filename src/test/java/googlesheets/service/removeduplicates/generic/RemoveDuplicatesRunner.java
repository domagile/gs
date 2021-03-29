package googlesheets.service.removeduplicates.generic;

import googlesheets.service.GlobalContext;
import googlesheets.service.generic.addon.AddonRunner;

public abstract class RemoveDuplicatesRunner extends AddonRunner
{
    private static final String POWER_TOOLS_SECTION_ICON_ID = "imageDedupeTab";
    private static final String MENU_TEXT_REMOVE_DUPLICATES = "Remove Duplicates";
    private static final String MENU_TEXT_REMOVE_DUPLICATES_RC = "Remove Duplicates RC";


    public RemoveDuplicatesRunner(String powerToolsAddonIconId, String addonMenuItemText) {
        super(POWER_TOOLS_SECTION_ICON_ID, powerToolsAddonIconId, getRemoveDuplicatesMenuText(), addonMenuItemText);
    }


    private static String getRemoveDuplicatesMenuText() {
        return GlobalContext.TEST_RC_VERSION ? MENU_TEXT_REMOVE_DUPLICATES_RC : MENU_TEXT_REMOVE_DUPLICATES;
    }
}
