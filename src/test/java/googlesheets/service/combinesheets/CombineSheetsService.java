package googlesheets.service.combinesheets;

import googlesheets.service.EntityList;
import googlesheets.service.generic.WebDriverService;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.GenericAddonService.switchDriverToAddonIframe;

public class CombineSheetsService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();


    public static void selectAdditionalOptions(CombineSheetsOptions options) {
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
                sleep(1000);
                break;
        }
    }


    public static void selectSheetsToCombine(int... sheets) {
        EntityList sheetList = expandSheetList();
        Arrays.stream(sheets).forEach(sheetList::clickEntity);
        clickNext();
    }


    private static EntityList expandSheetList() {
        switchDriverToAddonIframe();

        WebElement tBody = driver.findElement(By.cssSelector(".first-step-table-body"));
        List<WebElement> trs = tBody.findElements(By.tagName("tr"));
        //if list is loaded during long time
        while (trs.isEmpty()) {
            sleep(1000);
            trs = tBody.findElements(By.tagName("tr"));
        }
        WebElement td = trs.get(0).findElements(By.tagName("td")).get(0);
        td.click();
        return new EntityList(trs, 1);
    }


    private static void switchToMainWindow() {
        driver.switchTo().defaultContent();
    }


    public static void runCombineSheets() {
        clickAddonsMenu();
        clickCombineSheetsMenu();
        clickStartMenu();
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        sleep(5000);
    }



    private static void clickStartMenu() {
        clickMenuItem("Start");
    }


    private static void clickCombineSheetsMenu() {
        clickMenuItem("Combine Sheets");
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
        clickRadioButton("place0");
    }


    private static void chooseStoreToNewSheet() {
        clickRadioButton("place1");
    }


    private static void chooseStoreToCustomLocation() {
        clickRadioButton("place2");
    }


    private static void setCustomLocationValue(String locationValue) {
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
            sleep(1000);
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
        setCheckboxValue(value, "bSheetHasHeaders");
    }


    private static void setSeparateByBlankRow(boolean value)
    {
        setCheckboxValue(value, "bSeparate");
    }
}

