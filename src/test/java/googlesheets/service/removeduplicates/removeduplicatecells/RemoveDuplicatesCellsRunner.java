package googlesheets.service.removeduplicates.removeduplicatecells;

import googlesheets.service.removeduplicates.generic.RemoveDuplicatesRunner;

public class RemoveDuplicatesCellsRunner extends RemoveDuplicatesRunner {
    private static final String POWER_TOOLS_ADDON_ICON_ID = "power-tools-data-remove-duplicate-cells";
    private static final String MENU_TEXT_FIND_DUPLICATE_OR_UNIQUE_CELLS = "Find duplicate or unique cells";

    public RemoveDuplicatesCellsRunner() {
        super(POWER_TOOLS_ADDON_ICON_ID, MENU_TEXT_FIND_DUPLICATE_OR_UNIQUE_CELLS);
    }
}
