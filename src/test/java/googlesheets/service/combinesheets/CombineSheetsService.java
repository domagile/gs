package googlesheets.service.combinesheets;

import googlesheets.service.WebDriverService;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

public class CombineSheetsService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();


    public static void selectAdditionalOptions(CombineSheetsOptions options) throws InterruptedException {
        setConsiderTableHeaders(options.isConsiderTableHeaders());
        setSeparateByBlankRow(options.isSeparateByBlankRow());

        //todo: add other location options
        switch (options.getResultLocation()) {
            case NEW_SHEET:
                chooseStoreToNewSheet();
                break;
            case CUSTOM_LOCATION:
                chooseStoreToCustomLocation();
                setCustomLocationValue(options.getLocationValue());
                //let "Invalid range" message disappear
                Thread.sleep(1000);
                break;
        }
    }


    public static void selectSheetsToCombine(int... sheets) throws InterruptedException {
        SheetList sheetList = expandSheetList();
        Arrays.stream(sheets).forEach(sheetList::selectSheet);
        clickNext();
    }


    private static SheetList expandSheetList() throws InterruptedException {
        List<WebElement> iFrames = driver.findElements(By.tagName("iframe"));
        WebElement iFrame = iFrames.get(iFrames.size() - 1);
        driver.switchTo().frame(iFrame);
        WebElement sandboxFrame = driver.findElement(By.id("sandboxFrame"));
        driver.switchTo().frame(sandboxFrame);
        WebElement userHtmlFrame = driver.findElement(By.id("userHtmlFrame"));
        driver.switchTo().frame(userHtmlFrame);

        WebElement tBody = driver.findElement(By.cssSelector(".first-step-table-body"));
        List<WebElement> trs = tBody.findElements(By.tagName("tr"));
        //if list is loaded during long time
        while (trs.isEmpty()) {
            Thread.sleep(1000);
            trs = tBody.findElements(By.tagName("tr"));
        }
        WebElement td = trs.get(0).findElements(By.tagName("td")).get(0);
        td.click();
        return new SheetList(trs);
    }


    private static void switchToMainWindow() {
        driver.switchTo().defaultContent();
    }


    public static void runCombineSheets() throws InterruptedException {
        clickAddonsMenu();
        clickCombineSheetsMenu();
        clickStartMenu();
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        Thread.sleep(5000);
    }



    private static void clickAddonsMenu() throws InterruptedException {
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


    private static void clickStartMenu() {
        clickMenuItem("Start");
    }


    private static void clickCombineSheetsMenu() {
        clickMenuItem("Combine Sheets");
    }


    private static void clickMenuItem(String menuName) {
        String xpath = "//*[text()='" + menuName + "']";
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        driver.findElement(By.xpath(xpath)).click();
    }


    public static void waitForCompletionAndClose() {
        //todo: change to "contains" to get universal check
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[text()='Ranges from 2 sheets have been successfully combined. ']")));

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("combineSheetsClose")));
        //todo: if banner is shown then press "Return to add-on"
        driver.findElement(By.id("combineSheetsClose")).click();

        driver.switchTo().defaultContent();
    }


    private static void chooseStoreToNewSpreadsheet() {
        clickLocationRadioButton("place0");
    }


    private static void chooseStoreToNewSheet() {
        clickLocationRadioButton("place1");
    }


    private static void chooseStoreToCustomLocation() {
        clickLocationRadioButton("place2");
    }


    private static void clickLocationRadioButton(String place0) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(place0)));
        //isDisplayed() returns false by some reason
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                driver.findElement(By.id(place0)));
    }


    private static void setCustomLocationValue(String locationValue) throws InterruptedException {
        try {
            WebElement customLocationField = driver.findElement(By.id("txtCustomLocation"));
            customLocationField.clear();
            Actions builder = new Actions(driver);
            Action actions = builder
                    .sendKeys(customLocationField, locationValue).build();
            actions.perform();

//            customLocationField.sendKeys(locationValue);
        }
        catch (InvalidElementStateException e) {
            Thread.sleep(1000);
            setCustomLocationValue(locationValue);
        }
    }


    public static void clickNext()
    {
        driver.findElement(By.id("combineSheetsNext")).click();
    }


    public static void clickCombineAndClose() {
        driver.findElement(By.id("combineSheetsNext")).click();
        waitForCompletionAndClose();
    }


    private static void setConsiderTableHeaders(boolean value)
    {
        setOptionCheckboxValue(value, "bSheetHasHeaders");
    }


    private static void setSeparateByBlankRow(boolean value)
    {
        setOptionCheckboxValue(value, "bSeparate");
    }


    private static void setOptionCheckboxValue(boolean value, String bSheetHasHeaders) {
        WebElement checkbox = driver.findElement(By.id(bSheetHasHeaders));
        if (checkbox.isSelected() != value) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
                    checkbox);
        }
    }
}

