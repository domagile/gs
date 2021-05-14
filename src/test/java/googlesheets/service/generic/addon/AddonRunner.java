package googlesheets.service.generic.addon;

import googlesheets.service.GlobalContext;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static googlesheets.service.generic.addon.FunctionReinvocationUtil.invokeFunctionWithReinvocation;
import static googlesheets.service.generic.addon.GenericAddonService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.webdriver.FieldHelper.getElements;

public class AddonRunner {
    private String powerToolsSectionIconId;
    private By powerToolsAddonIconLocator;
    private String groupMenuItemText;
    private String lastMenuItemText;

    public AddonRunner(String powerToolsSectionIconId, String powerToolsAddonIconId, String groupMenuItemText,
                       String lastMenuItemText) {
        this(powerToolsSectionIconId, By.id(powerToolsAddonIconId), groupMenuItemText, lastMenuItemText);
    }

    public AddonRunner(String powerToolsSectionIconId, By powerToolsAddonIconLocator, String groupMenuItemText,
                       String lastMenuItemText) {
        this.powerToolsSectionIconId = powerToolsSectionIconId;
        this.powerToolsAddonIconLocator = powerToolsAddonIconLocator;
        this.groupMenuItemText = groupMenuItemText;
        this.lastMenuItemText = lastMenuItemText;
    }

    public void runAddon() {
        if (isPowerToolsMode()) {
            runThroughPowerTools();
        } else {
            runAsSeparateAddon();
        }
    }

    protected boolean isPowerToolsMode() {
        return GlobalContext.IS_POWER_TOOLS_MODE;
    }


    private void runThroughPowerTools() {
        IFrameInfo iFrameInfo = runPowerTools();
        GlobalContext.getInstance().setFirstAddonTopIFrameSrc(iFrameInfo.getTopIframeSrc());
        clickElement(powerToolsSectionIconId);
        //fixme: no reaction to click without this delay
        sleep(2000);
        invokeFunctionWithReinvocation(this::clickAddonPowerToolsIcon);
        if (!isSidePanelAddon()) {
            switchDriverToAddonIframe();
        }
    }

    protected boolean isSidePanelAddon() {
        return false;
    }


    private boolean clickAddonPowerToolsIcon() {
        clickElement(getAddonIconElement(powerToolsAddonIconLocator));
        if (isSidePanelAddon()) {
            return true;
        }
        return waitForCondition(GenericAddonService::isWorkingMessageDisplayed, 4, 500);
    }


    private WebElement getAddonIconElement(By locator) {
        List<WebElement> elements = getElements(locator);
        if (elements.size() == 1) {
            return elements.get(0);
        }
        else if (elements.size() == 2) {
            return elements.get(elements.get(0).isDisplayed() ? 0 : 1);
        }
        else {
            throw new IllegalStateException("More than 2 elements: " + elements.size());
        }
    }


    protected void runAsSeparateAddon() {
        runAddonThroughMenu(lastMenuItemText);
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        sleep(5000);

        IFrameInfo iFrameInfo = switchDriverToAddonIframe();
        GlobalContext.getInstance().setFirstAddonTopIFrameSrc(iFrameInfo.getTopIframeSrc());
    }


    private static IFrameInfo runPowerTools() {
        clickAddonsMenu();
        clickHighLevelMenuItem(getPowerToolsMenuText(), "Start");
        clickMenuItem("Start");
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        sleep(5000);
        return switchDriverToAddonIframe();
    }

    private static String getPowerToolsMenuText() {
        return "Power Tools" + (GlobalContext.TEST_RC_VERSION ? " RC" : "");
    }


    private void runAddonThroughMenu(String addonMenuName) {
        clickAddonsMenu();
        clickGroupMenu(addonMenuName);
        clickMenuItem(addonMenuName, isExactMenuItemText());
    }


    protected void clickGroupMenu(String addonMenuName) {
        clickHighLevelMenuItem(getGroupMenuItemText(), lastMenuItemText, isExactMenuItemText());
    }


    private String getGroupMenuItemText()
    {
        return GlobalContext.TEST_RC_VERSION ? groupMenuItemText + " RC" : groupMenuItemText;
    }


    protected boolean isExactMenuItemText() {
        return true;
    }
}
