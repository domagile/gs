package googlesheets.service.generic;

import googlesheets.service.GlobalContext;
import googlesheets.service.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.function.Function;
import java.util.function.Supplier;

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
            switchDriverToAddonIframe();
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


    private static void switchToAddonIframe(WebElement iFrame) {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(iFrame);
        WebElement sandboxFrame = driver.findElement(By.id("sandboxFrame"));
        driver.switchTo().frame(sandboxFrame);
        WebElement userHtmlFrame = driver.findElement(By.id("userHtmlFrame"));
        driver.switchTo().frame(userHtmlFrame);
    }
}
