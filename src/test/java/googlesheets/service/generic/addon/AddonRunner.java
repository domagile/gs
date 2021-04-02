package googlesheets.service.generic.addon;

import googlesheets.service.GlobalContext;
import googlesheets.service.generic.WebDriverService;
import org.openqa.selenium.By;

import static googlesheets.service.generic.addon.GenericAddonService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class AddonRunner {
    private String powerToolsSectionIconId;
    private String powerToolsAddonIconId;
    private String groupMenuItemText;
    private String lastMenuItemText;

    public AddonRunner(String powerToolsSectionIconId, String powerToolsAddonIconId, String groupMenuItemText,
                       String lastMenuItemText) {
        this.powerToolsSectionIconId = powerToolsSectionIconId;
        this.powerToolsAddonIconId = powerToolsAddonIconId;
        this.groupMenuItemText = groupMenuItemText;
        this.lastMenuItemText = lastMenuItemText;
    }

    public void runAddon() {
        if (GlobalContext.IS_POWER_TOOLS_MODE) {
            runThroughPowerTools();
        } else {
            runAsSeparateAddon();
        }
    }


    private void runThroughPowerTools() {
        IFrameInfo iFrameInfo = runPowerTools();
        GlobalContext.getInstance().setPowerToolsTopIFrameSrc(iFrameInfo.getTopIframeSrc());
        clickElement(powerToolsSectionIconId);
        //fixme: no reaction to click without this delay
        sleep(2000);
        invokeFunctionWithReinvocation(this::clickAddonPowerToolsIcon);
        switchDriverToAddonIframe();
    }


    private boolean clickAddonPowerToolsIcon() {
        clickElement(powerToolsAddonIconId);
        return waitForCondition(AddonRunner::isWorkingMessageDisplayed, 4, 500);
    }


    private static boolean isWorkingMessageDisplayed() {
        return WebDriverService.getInstance().getDriver().findElement(By.id("adxPreloader")).getCssValue("display").equals("flex");
    }


    private void runAsSeparateAddon() {
        runAddonThroughMenu(lastMenuItemText);
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        sleep(5000);

        switchDriverToAddonIframe();
    }


    private static IFrameInfo runPowerTools() {
        clickAddonsMenu();
        clickHighLevelMenuItem("Power Tools", "Start");
        clickMenuItem("Start");
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        sleep(5000);
        return switchDriverToAddonIframe();
    }


    private void runAddonThroughMenu(String addonMenuName) {
        clickAddonsMenu();
        clickGroupMenu(addonMenuName);
        clickMenuItem(addonMenuName, isExactMenuItemText());
    }


    protected void clickGroupMenu(String addonMenuName) {
        clickHighLevelMenuItem(groupMenuItemText, lastMenuItemText, isExactMenuItemText());
    }


    protected boolean isExactMenuItemText() {
        return true;
    }
}
