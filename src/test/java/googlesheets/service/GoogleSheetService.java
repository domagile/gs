package googlesheets.service;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;

import static googlesheets.service.FileService.compareFileWithEtalon;
import static googlesheets.service.FileService.removeDownloadedListFile;

public class GoogleSheetService {
    private static final String LOGIN = "gsheetauto";
    private static final String PASSWORD = "Cfqnktdsq1";

    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();



    public static void openDoc(String link) throws InterruptedException {
        driver.get(link);
        login();
    }


    public static void login() throws InterruptedException {
        if (GlobalContext.getInstance().isLoggedIn())
            return;

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("identifierId")));
        driver.findElement(By.id("identifierId")).sendKeys(LOGIN);
        driver.findElement(By.id("identifierNext")).click();

        wait.until(ExpectedConditions.elementToBeClickable(By.name("password")));
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.id("passwordNext")).click();
        //todo: if window with second authorization then: choose confirmation with second mail, enter second mail
        //todo: if "Protect your account" window then press Confirm

        GlobalContext.getInstance().setLoggedIn(true);

        //let document to load
        Thread.sleep(5000);
    }


    public static void startCSVDownload() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='File']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[@aria-label='Download d']")));

        driver.findElement(By.xpath("//*[@aria-label='Download d']")).click();
        Thread.sleep(1000);
        driver.findElement(
                By.xpath("//*[@aria-label='Comma-separated values (.csv, current sheet) c']")).click();
    }


    public static void clickDialogOK() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.name("ok")));
        driver.findElement(By.name("ok")).click();
    }


    public static void openSheetContextMenu(String sheetName) throws InterruptedException {
        Actions actions = new Actions(driver);
        By xpath = By.xpath("//*[text()='" + sheetName + "']");
        wait.until(ExpectedConditions.presenceOfElementLocated(xpath));
        WebElement elementLocator = driver.findElement(xpath);
        try {
            actions.contextClick(elementLocator).perform();
        }
        catch (StaleElementReferenceException e) {
            Thread.sleep(1000);
            openSheetContextMenu(sheetName);
        }
    }


    public static void clickContextMenuByText(String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='" + text + "']")));
        driver.findElement(By.xpath("//*[text()='" + text + "']")).click();
    }


    public static void removeListThroughMenu(String listName) throws InterruptedException {
        openSheetContextMenu(listName);
        clickContextMenuByText("Delete");
        clickDialogOK();
    }


    public static void duplicateListThroughMenu(String listName) throws InterruptedException {
        openSheetContextMenu(listName);
        clickContextMenuByText("Duplicate");
    }


    public static void checkResult(String spreadsheetName, String resultListName, String etalonFile) throws InterruptedException, IOException {
        checkResult(spreadsheetName, resultListName, etalonFile, true);
    }

    public static void checkResult(String spreadsheetName, String resultListName, String etalonFile, boolean removeList) throws InterruptedException, IOException {
        startCSVDownload();
        if (removeList) {
            removeListThroughMenu(resultListName);
        }
        compareFileWithEtalon(spreadsheetName, resultListName, etalonFile);
        removeDownloadedListFile(spreadsheetName, resultListName);
    }


    public static void clickAddonsMenu() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Add-ons']")));
        try {
            driver.findElement(By.xpath("//*[text()='Add-ons']")).click();
        }
        //"Working" message prevents from clicking if it's done right after login
        catch (ElementClickInterceptedException e)
        {
            Thread.sleep(1000);
            clickAddonsMenu();
        }
    }


    public static void clickMenuItem(String menuName) throws InterruptedException {
        String xpath = "//*[text()='" + menuName + "']";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        try {
            driver.findElement(By.xpath(xpath)).click();
        }
        catch (ElementClickInterceptedException e) {
            Thread.sleep(2000);
            clickMenuItem(menuName);
        }
    }


    public static void clickHighLevelMenuItem(String menuName, String nextMenuName) {
        String xpath = "//*[text()='" + menuName + "']";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
        try {
            xpath = "//*[text()='" + nextMenuName + "']";
            wait.withTimeout(Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        }
        catch (TimeoutException e) {
            //fixme: repeat invocation only 1 time
            clickHighLevelMenuItem(menuName, nextMenuName);
        }
        finally {
            WebDriverService.getInstance().resetWaitTimeout();
        }
    }


    public static void clickRadioButton(String buttonId) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(buttonId)));
        //isDisplayed() returns false by some reason
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(By.id(buttonId)));
    }


    public static void setCheckboxValue(boolean value, String checkboxId) {
        WebElement checkbox = driver.findElement(By.id(checkboxId));
        if (checkbox.isSelected() != value) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    checkbox);
        }
    }
}
