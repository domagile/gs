package googlesheets.service.generic.addon;

import googlesheets.service.generic.WebDriverService;
import googlesheets.service.generic.google.GoogleSheetService;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public abstract class GenericAddonService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();


    public static IFrameInfo switchDriverToAddonIframe() {
        return switchDriverToCheckedAddonIframe(iFrame -> true);
    }


    public static IFrameInfo switchDriverToCheckedAddonIframe(Predicate<WebElement> iFramePredicate) {
        boolean switched = false;
        String topIframeSrc = null;

        List<WebElement> iFrames = driver.findElements(By.tagName("iframe"));
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
            driver.switchTo().defaultContent();
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
            //todo: replace with reinvoke with multiple params
            sleep(1000);
            invokeFunctionWithReinvocation(function, parameter, exceptionTypes);
        }
    }


    public static <T> void invokeFunctionWithReinvocation(BooleanSupplier function) {
        if (!function.getAsBoolean()) {
            sleep(1000);
            invokeFunctionWithReinvocation(function);
        }
    }


    private static void switchToAddonIframe(WebElement iFrame) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iFrame);
        WebElement sandboxFrame = driver.findElement(By.id("sandboxFrame"));
        driver.switchTo().frame(sandboxFrame);
        WebElement userHtmlFrame = driver.findElement(By.id("userHtmlFrame"));
        driver.switchTo().frame(userHtmlFrame);
    }


    public static ResultInfo waitForNewSpreadsheetAndClose() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='new spreadsheet']")));
        Optional<String> newSpreadsheetLink = getNewSpreadsheetLink();
        GoogleSheetService.clickElement("closeButton");
        driver.switchTo().defaultContent();
        return new ResultInfo(newSpreadsheetLink.orElse(null));
    }


    private static Optional<String> getNewSpreadsheetLink() {
        By xpath = By.xpath("//*[text()='new spreadsheet']");
        List<WebElement> links = driver.findElements(xpath);
        return !links.isEmpty() ? Optional.of(links.get(0).getAttribute("href")) : Optional.empty();
    }
}
