package googlesheets.service.removeduplicates.removeduplicatesrows;

import googlesheets.service.removeduplicates.generic.RemoveDuplicatesRunner;

public class RemoveDuplicatesRowsRunner extends RemoveDuplicatesRunner
{
    public static final String POWER_TOOLS_ADDON_ICON_ID = "power-tools-data-remove-duplicate";
    public static final String MENU_TEXT_FIND_DUPLICATE_OR_UNIQUE_ROWS = "Find duplicate or unique rows";

    public RemoveDuplicatesRowsRunner() {
        super(POWER_TOOLS_ADDON_ICON_ID, MENU_TEXT_FIND_DUPLICATE_OR_UNIQUE_ROWS);
    }
}
