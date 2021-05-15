package googlesheets.service.process.functionbycolor;

import googlesheets.service.generic.addon.AddonRunner;
import googlesheets.service.generic.xpath.XPathHelper;
import org.openqa.selenium.By;

import static googlesheets.service.generic.addon.GenericAddonService.isWorkingMessageDisplayed;
import static googlesheets.service.generic.addon.GenericAddonService.waitForWorkingMessage;

public class FunctionByColorRunner extends AddonRunner {
    private static final String POWER_TOOLS_SECTION_ICON_ID = "imageDataTab";
    private static final String GROUP_MENU_TEXT = "Function by Color";
    private static final String LAST_MENU_TEXT = "Start";


    public FunctionByColorRunner() {
        super(POWER_TOOLS_SECTION_ICON_ID, By.xpath(XPathHelper.attributeIs("for", "functionByColorTab")),
                GROUP_MENU_TEXT, LAST_MENU_TEXT);
    }


    @Override
    protected boolean isSidePanelAddon() {
        return true;
    }


    @Override
    protected void runAsSeparateAddon() {
        super.runAsSeparateAddon();
        if (isWorkingMessageDisplayed()) {
            waitForWorkingMessage(false);
        }
    }
}
