package googlesheets.service.generic;

import googlesheets.service.GlobalContext;
import googlesheets.service.WebDriverService;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import static googlesheets.service.GoogleSheetService.sleep;

public abstract class GenericAddonService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();

    //todo: search for content in all iframes from the end
    public static void switchDriverToAddonIframe() {
        boolean switched = false;

        List<WebElement> iFrames = driver.findElements(By.tagName("iframe"));
        for (int i = iFrames.size() - 1; i >= 0; i--) {
            WebElement iFrame = iFrames.get(i);
            try {
                switchToAddonIframe(iFrame);
                switched = true;
                break;
            } catch (NoSuchElementException e) {
                //do nothing
            }
        }

        if (!switched) {
            driver.switchTo().defaultContent();
            reinvokeFunctionWithDelay(GenericAddonService::switchDriverToAddonIframe);
        }
    }


    public static void reinvokeFunctionWithDelay(Runnable function)  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        function.run();
    }

    public static <T> void reinvokeFunctionWithDelay(Consumer<T> function, T parameter)  {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        function.accept(parameter);
    }


    public static <T> void invokeFunctionWithReinvocation(Consumer<T> function, T parameter, Class<? extends WebDriverException>... exceptionTypes)  {
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


    private static void switchToAddonIframe(WebElement iFrame) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iFrame);
        WebElement sandboxFrame = driver.findElement(By.id("sandboxFrame"));
        driver.switchTo().frame(sandboxFrame);
        WebElement userHtmlFrame = driver.findElement(By.id("userHtmlFrame"));
        driver.switchTo().frame(userHtmlFrame);
    }
}
