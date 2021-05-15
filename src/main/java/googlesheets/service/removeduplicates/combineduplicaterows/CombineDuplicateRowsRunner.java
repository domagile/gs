package googlesheets.service.removeduplicates.combineduplicaterows;

import googlesheets.service.removeduplicates.generic.RemoveDuplicatesRunner;

public class CombineDuplicateRowsRunner extends RemoveDuplicatesRunner {
    private static final String MENU_TEXT_COMBINE_DUPLICATE_ROWS = "Combine duplicate rows";
    private static final String POWER_TOOLS_ADDON_ICON_ID = "power-tools-data-combine-rows";


    public CombineDuplicateRowsRunner() {
        super(POWER_TOOLS_ADDON_ICON_ID, MENU_TEXT_COMBINE_DUPLICATE_ROWS);
    }

}
