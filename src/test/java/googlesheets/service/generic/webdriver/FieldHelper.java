package googlesheets.service.generic.webdriver;

import googlesheets.service.generic.xpath.XPathHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static googlesheets.service.generic.webdriver.Locators.TAG_IFRAME;
import static googlesheets.service.generic.xpath.XPathHelper.attributeIs;
import static org.openqa.selenium.By.xpath;

public class FieldHelper {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();


    public static WebElement getElement(String id)
    {
        return driver.findElement(By.id(id));
    }


    public static WebElement getElementByXpath(String xpath)
    {
        return driver.findElement(xpath(xpath));
    }


    public static WebElement getElementByAttribute(String attribute, String attributeValue)
    {
        return getElementByXpath(attributeIs(attribute, attributeValue));
    }


    public static WebElement getClickableElementByAttribute(String attribute, String attributeValue)
    {
        return getClickableElement(xpath(attributeIs(attribute, attributeValue)));
    }


    public static WebElement getPresentElement(String id)
    {
        By locator = By.id(id);
        return getPresentElement(locator);
    }


    public static WebElement getClickableElement(String id)
    {
        By locator = By.id(id);
        return getClickableElement(locator);
    }


    public static WebElement getClickableElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
        return driver.findElement(locator);
    }


    public static WebElement getPresentElementByXpath(String xpath)
    {
        By xpathLocator = xpath(xpath);
        return getPresentElement(xpathLocator);
    }


    private static WebElement getPresentElement(By locator) {
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
        return driver.findElement(locator);
    }


    public static WebElement getClickableElementByXpath(String xpath)
    {
        By xpathLocator = xpath(xpath);
        return getClickableElement(xpathLocator);
    }


//    public static WebElement getElement(By locator)
//    {
//        return driver.findElement(locator);
//    }


    public static WebElement getElementByName(String name)
    {
        return driver.findElement(By.name(name));
    }


    public static WebElement getElementByClassName(String className)
    {
        return driver.findElement(By.className(className));
    }


    public static WebElement getElementByCssSelector(String cssSelector)
    {
        return driver.findElement(By.cssSelector(cssSelector));
    }


    public static List<WebElement> getElements(By locator)
    {
        return driver.findElements(locator);
    }


    public static void waitElementPresentByXpath(String xpath) {
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath(xpath)));
    }

    public static void waitElementPresent(String elementId) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(elementId)));
    }


    public static void waitElementClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void waitElementClickable(String elementId) {
        wait.until(ExpectedConditions.elementToBeClickable(By.id(elementId)));
    }


    public static void waitElementClickableByName(String name) {
        wait.until(ExpectedConditions.elementToBeClickable(By.name(name)));
    }
}
