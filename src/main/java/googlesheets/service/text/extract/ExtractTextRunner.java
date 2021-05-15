package googlesheets.service.text.extract;

import googlesheets.service.generic.addon.AddonRunner;
import googlesheets.service.generic.xpath.XPathHelper;
import org.openqa.selenium.By;

public class ExtractTextRunner extends AddonRunner {
    private static final String POWER_TOOLS_SECTION_ICON_ID = "imageTextTab";


    public ExtractTextRunner() {
        super(POWER_TOOLS_SECTION_ICON_ID, By.xpath(XPathHelper.attributeIs("for", "extractTextButton")),
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
