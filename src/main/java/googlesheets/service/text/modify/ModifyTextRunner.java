package googlesheets.service.text.modify;

import googlesheets.service.generic.addon.AddonRunner;
import googlesheets.service.generic.xpath.XPathHelper;
import org.openqa.selenium.By;

public class ModifyTextRunner extends AddonRunner {
    private static final String POWER_TOOLS_SECTION_ICON_ID = "imageTextTab";


    public ModifyTextRunner() {
        super(POWER_TOOLS_SECTION_ICON_ID, By.xpath(XPathHelper.attributeIs("for", "modifyGroupeButton")),
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
