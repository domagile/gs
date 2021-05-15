package googlesheets.service.generic.webdriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebDriverService {
    public static final int DEFAULT_TIMEOUT = 15;
    private static WebDriverService instance;

    private WebDriver driver;
    private WebDriverWait wait;


    private WebDriverService() {
        System.setProperty("webdriver.chrome.driver", "c:\\app\\webdriver\\chromedriver_win32\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "D:\\app\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = createWait();
    }

    private WebDriverWait createWait() {
        return new WebDriverWait(driver, 15);
    }


    public static synchronized WebDriverService getInstance() {
        if (instance == null) {
            instance = new WebDriverService();
        }
        return instance;
    }


    public WebDriver getDriver() {
        return driver;
    }


    public WebDriverWait getWait() {
        return wait;
    }


    public void resetWaitTimeout() {
        wait.withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT));
    }


    public static void switchDriverToDefaultContent() {
        getInstance().getDriver().switchTo().defaultContent();
    }


    public static void switchDriverToFrame(WebElement iFrame) {
        getInstance().getDriver().switchTo().frame(iFrame);
    }


    public static WebDriverWait getWaitWithTimeout(int sec) {
        return new WebDriverWait(getInstance().getDriver(), sec);
    }


    public static void openLink(String link) {
        getInstance().getDriver().get(link);
    }
}
