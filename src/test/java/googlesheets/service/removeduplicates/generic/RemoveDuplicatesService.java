package googlesheets.service.removeduplicates.generic;

import googlesheets.service.GlobalContext;
import googlesheets.service.generic.GenericAddonService;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public abstract class RemoveDuplicatesService extends GenericAddonService {
    protected static final String MENU_TEXT_REMOVE_DUPLICATES = "Remove Duplicates";
    protected static final String MENU_TEXT_REMOVE_DUPLICATES_RC = "Remove Duplicates RC";


    private static String getRemoveDuplicatesMenuText() {
        return GlobalContext.TEST_RC_VERSION ? MENU_TEXT_REMOVE_DUPLICATES_RC : MENU_TEXT_REMOVE_DUPLICATES;
    }


    protected static void clickRemoveDuplicatesMenu(String nextMenuName) {
        clickRemoveDuplicatesMenu(nextMenuName, true);
    }


    protected static void clickRemoveDuplicatesMenu(String nextMenuName, boolean exactText) {
        clickHighLevelMenuItem(getRemoveDuplicatesMenuText(), nextMenuName, exactText);
    }


    protected static void runAddonThroughMenu(String addonMenuName) {
        clickAddonsMenu();
        clickRemoveDuplicatesMenu(addonMenuName);
        clickMenuItem(addonMenuName);
    }
}
