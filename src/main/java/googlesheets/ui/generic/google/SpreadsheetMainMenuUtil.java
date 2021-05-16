package googlesheets.ui.generic.google;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static googlesheets.service.generic.addon.FunctionReinvocationUtil.invokeFunctionWithReinvocation;
import static googlesheets.service.generic.google.GoogleSheetService.clickElement;
import static googlesheets.service.generic.webdriver.FieldHelper.getClickableElementByXpath;
import static googlesheets.service.generic.webdriver.FieldHelper.getPresentElementByXpath;
import static googlesheets.service.generic.webdriver.WebDriverService.getWaitWithTimeout;
import static googlesheets.service.generic.xpath.XPathHelper.*;
import static googlesheets.service.generic.xpath.XPathHelper.textContains;

public class SpreadsheetMainMenuUtil {
    public static void startCSVDownload() {
        clickMenuFile();
        clickMenuDownload();
        clickElement(By.xpath(attributeIs("aria-label", "Comma-separated values (.csv, current sheet) c")));
    }

    private static void clickMenuDownload() {
        clickElement(By.xpath(attributeIs("aria-label", "Download d")));
    }

    private static void clickMenuFile() {
        clickElement(By.xpath(textIs("File")));
    }

    public static void startXLSXDownload() {
        clickMenuFile();
        clickMenuDownload();
        clickElement(By.xpath(attributeIs("aria-label", "Microsoft Excel (.xlsx) x")));
    }


    public static void moveSpreadsheetToTrash() {
        clickMenuFile();
        clickElement(By.xpath(attributeIs("aria-label", "Move to trash t")));
    }


    public static void clickMenuAddons() {
        invokeFunctionWithReinvocation(() -> {
            getClickableElementByXpath(textIs("Add-ons")).click();
        }, ElementClickInterceptedException.class, UnhandledAlertException.class);
    }


    public static void clickHighLevelMenuItem(String menuName, String nextMenuName) {
        clickHighLevelMenuItem(menuName, nextMenuName, true);
    }

    public static void clickHighLevelMenuItem(String menuName, String nextMenuName, boolean exactText) {
        invokeFunctionWithReinvocation(() -> {
            String xpath = exactText ? textIs(menuName) : textContains(menuName);
            getPresentElementByXpath(xpath).click();
            xpath = exactText ? textIs(nextMenuName) : textContains(nextMenuName);
            getWaitWithTimeout(2).until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
        }, TimeoutException.class);
    }
}
