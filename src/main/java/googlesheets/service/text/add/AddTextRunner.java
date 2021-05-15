package googlesheets.service.text.add;

import googlesheets.service.generic.addon.AddonRunner;
import googlesheets.service.generic.xpath.XPathHelper;
import org.openqa.selenium.By;

public class AddTextRunner extends AddonRunner {
    private static final String POWER_TOOLS_SECTION_ICON_ID = "imageTextTab";


    public AddTextRunner() {
        super(POWER_TOOLS_SECTION_ICON_ID, By.xpath(XPathHelper.attributeIs("for", "textAddGroupeButton")),
                null, null);
    }


    @Override
    protected boolean isSidePanelAddon() {
        return true;
    }


    @Override
    protected boolean isPowerToolsMode() {
        return true;
    }
}
