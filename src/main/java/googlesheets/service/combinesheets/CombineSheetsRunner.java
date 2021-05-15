package googlesheets.service.combinesheets;

import googlesheets.service.generic.addon.AddonRunner;

public class CombineSheetsRunner extends AddonRunner {
    private static final String POWER_TOOLS_SECTION_ICON_ID = "imageMergeTab";
    private static final String POWER_TOOLS_ADDON_ICON_ID = "power-tools-data-combine-sheets";
    private static final String GROUP_MENU_TEXT = "Combine Sheets";
  //  private static final String GROUP_MENU_TEXT = "Copy of Combine Sheets";
   // private static final String GROUP_MENU_TEXT = "Consolidate Sheets";
    private static final String LAST_MENU_TEXT = "Start";


    public CombineSheetsRunner() {
        super(POWER_TOOLS_SECTION_ICON_ID, POWER_TOOLS_ADDON_ICON_ID, GROUP_MENU_TEXT, LAST_MENU_TEXT);
    }
}
