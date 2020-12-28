package googlesheets.service;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverService {
    private static WebDriverService instance;

    private WebDriver driver;
    private WebDriverWait wait;


    private WebDriverService()
    {
        System.setProperty("webdriver.chrome.driver", "c:\\app\\webdriver\\chromedriver_win32\\chromedriver.exe");
//        System.setProperty("webdriver.chrome.driver", "D:\\app\\chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 15);
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
}
