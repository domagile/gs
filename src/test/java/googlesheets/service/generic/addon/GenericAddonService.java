package googlesheets.service.generic.addon;

import googlesheets.service.GlobalContext;
import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import googlesheets.service.generic.webdriver.WebDriverService;
import googlesheets.service.generic.google.GoogleSheetService;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.*;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.webdriver.FieldHelper.getElement;
import static googlesheets.service.generic.webdriver.FieldHelper.getElements;
import static googlesheets.service.generic.webdriver.Locators.TAG_IFRAME;
import static googlesheets.service.generic.webdriver.WebDriverService.*;
import static googlesheets.service.generic.xpath.XPathHelper.textContainsExceptTag;
import static googlesheets.service.generic.xpath.XPathHelper.textIs;

public abstract class GenericAddonService {
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();
    public static final String FIELD_ID_NAME_BOX = "t-name-box";
    public static final String FIELD_ID_WORKING_MESSAGE_DIV = "adxPreloader";


    public static IFrameInfo switchDriverToAddonIframe() {
        if (GlobalContext.IS_POWER_TOOLS_MODE) {
            return switchDriverToCheckedAddonIframe(iFrame -> !iFrame.getAttribute("src").equals(
                    GlobalContext.getInstance().getPowerToolsTopIFrameSrc()));
        }
        else {
            return switchDriverToCheckedAddonIframe(iFrame -> true);
        }
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


    public static void reinvokeFunctionWithDelay(Runnable function) {
        sleep(1000);
        function.run();
    }

    public static <T> void reinvokeFunctionWithDelay(Consumer<T> function, T parameter) {
        sleep(1000);
        function.accept(parameter);
    }

    public static <T, R> R reinvokeFunctionWithDelay(Function<T, R> function, T parameter) {
        sleep(1000);
        return function.apply(parameter);
    }


    public static <T> void invokeFunctionWithReinvocation(Consumer<T> function, T parameter, Class<? extends WebDriverException>... exceptionTypes) {
        try {
            function.accept(parameter);
        } catch (WebDriverException e) {
            if (Arrays.stream(exceptionTypes).noneMatch(type -> type.isInstance(e)))
                throw e;
            if (GlobalContext.getInstance().registerFunctionInvocation(function)) {
                sleep(1000);
                invokeFunctionWithReinvocation(function, parameter, exceptionTypes);
            }
        }
    }


    public static <T, U> void invokeFunctionWithReinvocation(BiConsumer<T, U> function, T parameter1, U parameter2,
                                                             Class<? extends WebDriverException>... exceptionTypes) {
        try {
            function.accept(parameter1, parameter2);
        } catch (WebDriverException | FunctionInvocationException e) {
            if (Arrays.stream(exceptionTypes).noneMatch(type -> type.isInstance(e))
                    && !(e instanceof FunctionInvocationException))
                throw e;
            if (GlobalContext.getInstance().registerFunctionInvocation(function)) {
                sleep(1000);
                invokeFunctionWithReinvocation(function, parameter1, parameter2, exceptionTypes);
            }
        }
    }


    public static <T> void invokeFunctionWithReinvocation(Runnable function, Class<? extends WebDriverException>... exceptionTypes) {
        try {
            function.run();
        } catch (WebDriverException e) {
            if (Arrays.stream(exceptionTypes).noneMatch(type -> type.isInstance(e)))
                throw e;
            if (GlobalContext.getInstance().registerFunctionInvocation(function)) {
                sleep(1000);
                invokeFunctionWithReinvocation(function, exceptionTypes);
            }
        }
    }


    public static <T> void invokeFunctionWithReinvocation(BooleanSupplier function) {
        if (!function.getAsBoolean()) {
            sleep(1000);
            invokeFunctionWithReinvocation(function);
        }
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


    public static void setNameBoxValueFromAddonContext(String value)
    {
        switchDriverToDefaultContent();
        setNameBoxValue(value);
        switchDriverToAddonIframe();
    }


    public static void setNameBoxValue(String value)
    {
        setText(value + Keys.ENTER, FIELD_ID_NAME_BOX);
    }


    public static String getNameBoxValue()
    {
        return getElement(FIELD_ID_NAME_BOX).getAttribute("value");
    }


    public static String getNameBoxValueFromAddonContext() {
        switchDriverToDefaultContent();
        String value = getNameBoxValue();
        switchDriverToAddonIframe();
        return value;
    }


    public static void waitNameBoxValue(String text, int checkNumber, int pauseMillis)
    {
        switchDriverToDefaultContent();
        waitForCondition(() -> getNameBoxValue().equals(text), checkNumber, pauseMillis);
        switchDriverToAddonIframe();
    }


    public static boolean isWorkingMessageDisplayed() {
        return getElement(FIELD_ID_WORKING_MESSAGE_DIV).getCssValue("display").equals("flex");
    }


    public static void waitForWorkingMessageDisplayedAndHidden()
    {
        waitForWorkingMessageDisplayedAndHidden(GlobalContext.DEFAULT_WORKING_MESSAGE_TIMEOUT);
    }


    public static void waitForWorkingMessageDisplayedAndHidden(int timeoutSec)
    {
        waitForWorkingMessage(true, timeoutSec);
        waitForWorkingMessage(false, timeoutSec);
    }


    public static void waitForWorkingMessage(boolean isDisplayed)
    {
        waitForWorkingMessage(isDisplayed, GlobalContext.DEFAULT_WORKING_MESSAGE_TIMEOUT);
    }


    public static void waitForWorkingMessage(boolean isDisplayed, int timeoutSec)
    {
        WebDriverWait wait = getWaitWithTimeout(timeoutSec);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(
                String.format("//div[@id='%s' and @style='display: %s;']", FIELD_ID_WORKING_MESSAGE_DIV,
                        isDisplayed ? "flex" : "none"))));
    }
}
