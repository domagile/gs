package googlesheets.service.generic;

import googlesheets.service.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class GenericAddonService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();

    public static void switchDriverToAddonIframe() throws InterruptedException {
        try {
            List<WebElement> iFrames = driver.findElements(By.tagName("iframe"));
            WebElement iFrame = iFrames.get(iFrames.size() - 1);
            driver.switchTo().frame(iFrame);
            WebElement sandboxFrame = driver.findElement(By.id("sandboxFrame"));
            driver.switchTo().frame(sandboxFrame);
            WebElement userHtmlFrame = driver.findElement(By.id("userHtmlFrame"));
            driver.switchTo().frame(userHtmlFrame);
        }
        catch (NoSuchElementException e) {
            driver.switchTo().defaultContent();
            Thread.sleep(2000);
            switchDriverToAddonIframe();
        }
    }
}
