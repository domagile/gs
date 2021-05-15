package googlesheets.service.removeduplicates.comparetwosheets;

import googlesheets.service.removeduplicates.generic.RemoveDuplicatesRunner;

public class CompareTwoSheetsRunner extends RemoveDuplicatesRunner {
    public static final String POWER_TOOLS_ADDON_ICON_ID = "power-tools-data-compare-sheets";
    //incorrect symbols in the beginning of naming in released version - skip them
    public static final String MENU_TEXT_COMPARE_COLUMNS_OR_SHEETS = "pare columns or sheets";


    public CompareTwoSheetsRunner() {
        super(POWER_TOOLS_ADDON_ICON_ID, MENU_TEXT_COMPARE_COLUMNS_OR_SHEETS);
    }


    @Override
    protected boolean isExactMenuItemText() {
        return false;
    }
}
