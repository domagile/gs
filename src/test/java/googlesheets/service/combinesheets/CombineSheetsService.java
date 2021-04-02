package googlesheets.service.combinesheets;

import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.service.EntityList;
import googlesheets.service.generic.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static googlesheets.service.generic.addon.GenericAddonService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class CombineSheetsService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();

    public static final String BUTTON_ID_CLOSE = "combineSheetsClose";
    public static final String FIELD_ID_CUSTOM_LOCATION = "txtCustomLocation";


    public static void selectHowToCopyDataOptions(CombineSheetsOptions options) {
        setConsiderTableHeaders(options.isConsiderTableHeaders());
        setUseFormulaToCombineSheets(options.isUseFormula());
        setPreserveFormatting(options.isPreserveFormatting());
        setSeparateByBlankRow(options.isSeparateByBlankRow());
    }


    public static void selectResultLocation(CombineSheetsOptions options) {
        switch (options.getResultLocation()) {
            case NEW_SHEET:
                chooseStoreToNewSheet();
                break;
            case NEW_SPREADSHEET:
                chooseStoreToNewSpreadsheet();
                break;
            case CUSTOM_LOCATION:
                chooseStoreToCustomLocation();
                invokeFunctionWithReinvocation(CombineSheetsService::setCustomLocationValue,
                        options.getCustomLocationValue(), InvalidElementStateException.class);
                //let "Invalid range" message disappear
                sleep(1000);
                break;
        }
    }


    public static void selectSheetsToCombine(int... sheets) {
        EntityList sheetList = expandSheetList();
        Arrays.stream(sheets).forEach(sheetList::clickEntity);
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
        By customLocationLocator = By.id(FIELD_ID_CUSTOM_LOCATION);
//        wait.until(ExpectedConditions.presenceOfElementLocated(customLocationLocator));
        //fixme: replace with some check
        //dynamic behaviour fills the field with some default value
        sleep(3000);
        driver.findElement(customLocationLocator).clear();
        driver.findElement(customLocationLocator).sendKeys(locationValue);
        //dynamic behaviour reacts to entered value
        sleep(2000);
        checkText(locationValue, FIELD_ID_CUSTOM_LOCATION, CombineSheetsService::setCustomLocationValue);
    }


    public static void clickNext() {
        clickElement("combineSheetsNext");
    }


    public static void clickCombineAndClose() {
        clickCombine();
        waitForCompletionAndClose("have been successfully combined", BUTTON_ID_CLOSE);
    }

    public static void clickCombine() {
        clickElement("combineSheetsNext");
    }


    private static void setConsiderTableHeaders(boolean value) {
        setCheckboxValue(value, "bSheetHasHeaders");
    }


    private static void setSeparateByBlankRow(boolean value) {
        setCheckboxValue(value, "bSeparate");
    }


    private static void setUseFormulaToCombineSheets(boolean value) {
        setCheckboxValue(value, "bInsertFormula");
    }


    private static void setPreserveFormatting(boolean value) {
        setCheckboxValue(value, "bPreserveFormatting");
    }
}

