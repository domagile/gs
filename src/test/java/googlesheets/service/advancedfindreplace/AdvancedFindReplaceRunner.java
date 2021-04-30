package googlesheets.service.advancedfindreplace;

import googlesheets.service.generic.addon.AddonRunner;
import googlesheets.service.generic.xpath.XPathHelper;
import org.openqa.selenium.By;

public class AdvancedFindReplaceRunner extends AddonRunner {
    private static final String POWER_TOOLS_SECTION_ICON_ID = "imageDataTab";
    private static final String GROUP_MENU_TEXT = "Advanced Find and Replace";
    private static final String LAST_MENU_TEXT = "Start";


    public AdvancedFindReplaceRunner() {
        super(POWER_TOOLS_SECTION_ICON_ID, By.xpath(XPathHelper.attributeIs("for", "btnToolFindAndReplaceController")),
                GROUP_MENU_TEXT, LAST_MENU_TEXT);
    }


    @Override
    protected boolean isSidePanelAddon() {
        return true;
    }
}
