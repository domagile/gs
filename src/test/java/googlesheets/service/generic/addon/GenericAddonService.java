package googlesheets.service.generic.addon;

import googlesheets.service.GlobalContext;
import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import googlesheets.service.generic.google.GoogleSheetService;
import googlesheets.service.generic.webdriver.FieldHelper;
import googlesheets.service.generic.webdriver.WebDriverService;
import org.apache.poi.openxml4j.opc.internal.FileHelper;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static googlesheets.service.generic.addon.FunctionReinvocationUtil.reinvokeFunctionWithDelay;
import static googlesheets.service.generic.google.GoogleSheetService.setText;
import static googlesheets.service.generic.google.GoogleSheetService.waitForCondition;
import static googlesheets.service.generic.webdriver.FieldHelper.*;
import static googlesheets.service.generic.webdriver.Locators.TAG_IFRAME;
import static googlesheets.service.generic.webdriver.WebDriverService.*;
import static googlesheets.service.generic.xpath.XPathHelper.textContainsExceptTag;
import static googlesheets.service.generic.xpath.XPathHelper.textIs;

public abstract class GenericAddonService {
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();
    public static final String FIELD_ID_NAME_BOX = "t-name-box";
    public static final String FIELD_ID_WORKING_MESSAGE_DIV = "adxPreloader";
    public static final String FIELD_ID_PROGRESS_MESSAGE_DIV = "adxProgress";


    public static IFrameInfo switchDriverToAddonIframe() {
        if (GlobalContext.IS_POWER_TOOLS_MODE) {
            return switchDriverToCheckedAddonIframe(iFrame -> !iFrame.getAttribute("src").equals(
                    GlobalContext.getInstance().getFirstAddonTopIFrameSrc()));
        } else {
            return switchDriverToCheckedAddonIframe(iFrame -> true);
        }
    }


    public static void switchDriverToFirstAddonIframe() {
        switchDriverToDefaultContent();
        switchDriverToCheckedAddonIframe(iFrame -> iFrame.getAttribute("src").equals(
                GlobalContext.getInstance().getFirstAddonTopIFrameSrc()));
    }


    public static void switchDriverToSecondAddonIframe() {
        switchDriverToDefaultContent();
        switchDriverToCheckedAddonIframe(iFrame -> !iFrame.getAttribute("src").equals(
                GlobalContext.getInstance().getFirstAddonTopIFrameSrc()));
    }


    public static IFrameInfo switchDriverToCheckedAddonIframe(Predicate<WebElement> iFramePredicate) {
        boolean switched = false;
        String topIframeSrc = null;

        List<WebElement> iFrames = getElements(TAG_IFRAME);
        for (int i = iFrames.size() - 1; i >= 0; i--) {
            WebElement iFrame = iFrames.get(i);

            try {
                topIframeSrc = iFrame.getAttribute("src");
                if (!iFramePredicate.test(iFrame)) {
                    break;
                }
                switchToAddonIframe(iFrame);
                switched = true;
                break;
            } catch (NoSuchElementException | StaleElementReferenceException e) {
                //do nothing
            }
        }

        if (!switched) {
            switchDriverToDefaultContent();
            //todo: fix reinvocation
            return reinvokeFunctionWithDelay(GenericAddonService::switchDriverToCheckedAddonIframe, iFramePredicate);
        }
        return new IFrameInfo(topIframeSrc);
    }


    private static void switchToAddonIframe(WebElement iFrame) {
        switchDriverToDefaultContent();
        switchDriverToFrame(iFrame);
        WebElement sandboxFrame = getElement("sandboxFrame");
        switchDriverToFrame(sandboxFrame);
        WebElement userHtmlFrame = getElement("userHtmlFrame");
        switchDriverToFrame(userHtmlFrame);
    }


    public static ResultInfo waitForNewSpreadsheetAndClose() {
        return waitForNewSpreadsheetAndClose("new spreadsheet", "closeButton");
    }


    public static ResultInfo waitForNewSpreadsheetAndClose(String newSpreadsheetLinkText, String closeButtonId) {
        By newSpreadsheetLinkLocator = By.xpath(textIs(newSpreadsheetLinkText));
        wait.until(ExpectedConditions.presenceOfElementLocated(newSpreadsheetLinkLocator));
        Optional<String> newSpreadsheetLink = getNewSpreadsheetLink(newSpreadsheetLinkLocator);
        GoogleSheetService.clickElement(closeButtonId);
        switchDriverToDefaultContent();
        return new ResultInfo(newSpreadsheetLink.orElse(null));
    }


    private static Optional<String> getNewSpreadsheetLink(By newSpreadsheetLinkLocator) {
        List<WebElement> links = getElements(newSpreadsheetLinkLocator);
        return !links.isEmpty() ? Optional.of(links.get(0).getAttribute("href")) : Optional.empty();
    }


    public static void waitForCompletionAndClose(String expectedTextPart, String closeButtonId) {
        WebDriverWait wait = getWaitWithTimeout(60);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(textContainsExceptTag(expectedTextPart, "script"))));
        //todo: if banner is shown then press "Return to add-on"
        GoogleSheetService.clickElement(closeButtonId);
        switchDriverToDefaultContent();
    }


    public static void setNameBoxValueFromAddonContext(String value) {
        switchDriverToDefaultContent();
        setNameBoxValue(value);
        switchDriverToAddonIframe();
    }


    public static void setNameBoxValue(String value) {
        setText(FIELD_ID_NAME_BOX, value + Keys.ENTER);
    }


    public static String getNameBoxValue() {
        return getElement(FIELD_ID_NAME_BOX).getAttribute("value");
    }


    public static String getNameBoxValueFromAddonContext() {
        switchDriverToDefaultContent();
        String value = getNameBoxValue();
        switchDriverToAddonIframe();
        return value;
    }


    public static void waitNameBoxValue(String text, int checkNumber, int pauseMillis) {
        switchDriverToDefaultContent();
        waitForCondition(() -> getNameBoxValue().equals(text), checkNumber, pauseMillis);
        switchDriverToAddonIframe();
    }


    public static boolean isWorkingMessageDisplayed() {
        waitElementPresent(FIELD_ID_WORKING_MESSAGE_DIV);
        return getElement(FIELD_ID_WORKING_MESSAGE_DIV).getCssValue("display").equals("flex");
    }


    public static void waitForWorkingMessageDisplayedAndHidden() {
        waitForWorkingMessageDisplayedAndHidden(GlobalContext.DEFAULT_WORKING_MESSAGE_TIMEOUT);
    }


    public static void waitForWorkingMessageDisplayedAndHidden(int timeoutSec) {
        waitForWorkingMessage(true, timeoutSec);
        waitForWorkingMessage(false, timeoutSec);
    }


    public static void waitForProgressMessageDisplayedAndHidden() {
        waitForProgressMessage(true, GlobalContext.DEFAULT_WORKING_MESSAGE_TIMEOUT);
        waitForProgressMessage(false, GlobalContext.DEFAULT_WORKING_MESSAGE_TIMEOUT);
    }


    public static void waitForWorkingMessage(boolean isDisplayed) {
        waitForWorkingMessage(isDisplayed, GlobalContext.DEFAULT_WORKING_MESSAGE_TIMEOUT);
    }


    public static void waitForWorkingMessage(boolean isDisplayed, int timeoutSec) {
        waitFor(getProgressBarLocator(FIELD_ID_WORKING_MESSAGE_DIV, isDisplayed), timeoutSec);
    }


    public static void waitForProgressMessage(boolean isDisplayed, int timeoutSec) {
        waitFor(getProgressBarLocator(FIELD_ID_PROGRESS_MESSAGE_DIV, isDisplayed), timeoutSec);
    }


    private static void waitFor(By locator, int timeoutSec) {
        WebDriverWait wait = getWaitWithTimeout(timeoutSec);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private static By getProgressBarLocator(String divId, boolean isDisplayed) {
        return By.xpath(
                String.format("//div[@id='%s' and @style='display: %s;']", divId,
                        isDisplayed ? "flex" : "none"));
    }
}
