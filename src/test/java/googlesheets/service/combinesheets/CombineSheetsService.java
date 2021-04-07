package googlesheets.service.combinesheets;

import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.sheetselection.SheetSelection;
import googlesheets.service.generic.WebDriverService;
import googlesheets.service.generic.addon.sheetselection.EntityList;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static googlesheets.service.generic.addon.GenericAddonService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.xpath.XPathHelper.attributeIs;
import static java.util.stream.Collectors.toList;

public class CombineSheetsService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();

    public static final String BUTTON_ID_CLOSE = "combineSheetsClose";
    public static final String FIELD_ID_CUSTOM_LOCATION = "txtCustomLocation";
    public static final String BUTTON_ID_COMBINE = "combineSheetsNext";
    public static final String FIELD_ID_CUSTOM_LOCATION_ON_LOCATION_DIALOG = "inputActiveRangeSmall";
    public static final String BUTTON_ID_OK_ON_LOCATION_DIALOG = "btnSmallOk";


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


    public static void selectSheetsToCombine(CombineSheetsOptions options)
    {
        if (options.getSpreadsheetSelections().isEmpty()) {
            selectSheetsFromCurrentSpreadsheet(options.getCombinedSheets());
        }
        else {
            selectSpreadsheetsToCombine(options.getSpreadsheetSelections());
        }
    }


    private static void selectSheetsFromCurrentSpreadsheet(List<SheetSelection> sheetSelections) {
        EntityList sheetList = expandSheetList();
        sheetList.selectEntitiesWithRanges(sheetSelections);
    }


    private static void selectSpreadsheetsToCombine(List<SpreadsheetSelection> sheets) {
        List<WebElement> trs = getSheetListTRs();
        List<WebElement> spreadsheetTRs = trs.stream()
                .filter(tr -> isSpreadsheetTR(tr)
                        && sheets.stream().anyMatch(selection -> selection.getSpreadsheetName().equals(getSpreadsheetNameFromTR(tr))))
                .collect(toList());
        spreadsheetTRs.forEach(tr -> tr.findElements(By.tagName("td")).get(0).click());
        List<Integer> spreadsheetIndexes = spreadsheetTRs.stream().map(trs::indexOf).collect(toList());
        List<List<WebElement>> spreadsheetTRSets = new ArrayList<>(spreadsheetIndexes.size());
        for (int i = 0; i < spreadsheetIndexes.size(); i++) {
            int firstIndex = spreadsheetIndexes.get(i);
            int lastIndex = spreadsheetIndexes.size() - 1 > i ? spreadsheetIndexes.get(i + 1) : trs.size();
            spreadsheetTRSets.add(trs.subList(firstIndex, lastIndex));
        }
        for (int i = 0; i < spreadsheetTRSets.size(); i++) {
            new EntityList(spreadsheetTRSets.get(i), 1).selectEntities(sheets.get(i).getSheetIndexes(), true, By.tagName("input"));
        }
    }

    private static boolean isSpreadsheetTR(WebElement tr) {
        return tr.getAttribute("class").contains("spreadsheet");
    }

    private static String getSpreadsheetNameFromTR(WebElement tr) {
        return tr.findElements(By.tagName("td")).get(2).getText();
    }


    private static EntityList expandSheetList() {
        List<WebElement> trs = getSheetListTRs();
        WebElement td = trs.get(0).findElements(By.tagName("td")).get(0);
        td.click();
        return new EntityList(trs, 1);
    }


    private static List<WebElement> getSheetListTRs() {
        WebElement tBody = driver.findElement(By.cssSelector(".first-step-table-body"));
        List<WebElement> trs = tBody.findElements(By.tagName("tr"));
        //if list is loaded during long time
        while (trs.isEmpty()) {
            sleep(1000);
            trs = tBody.findElements(By.tagName("tr"));
        }
        return trs;
    }


    private static void chooseStoreToNewSpreadsheet() {
        clickRadioButton("place0");
    }


    private static void chooseStoreToNewSheet() {
        clickRadioButton("place1");
    }


    public static void chooseStoreToCustomLocation() {
        clickRadioButton("place2");
    }


    public static void waitForCustomLocationValue(String value)
    {
        waitForCondition(() -> getCustomLocationField().getText().equals(value), 10, 1000);
    }


    public static void clickCustomLocationValueField()
    {
        getCustomLocationField().click();
    }


    private static void setCustomLocationValue(String locationValue) {
        WebElement customLocationField = getCustomLocationField();
        wait.until(ExpectedConditions.elementToBeClickable(customLocationField));
        customLocationField.clear();
        customLocationField.sendKeys(locationValue);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_ID_COMBINE)));
        checkText(locationValue, FIELD_ID_CUSTOM_LOCATION, CombineSheetsService::setCustomLocationValue);
    }

    private static WebElement getCustomLocationField() {
        return driver.findElement(By.id(FIELD_ID_CUSTOM_LOCATION));
    }

    /**
     * clear() method shouldn't be used: it removes focus and corresponding listener of addon is invoked
     * and we have conflict between behaviour of test and addon
     *
     * Finally there is a mess of approaches below what could be used or waited and so on to try to get it work.
     * For all the cases focus is lost after sendKeys and value is reset to selected cell if the field is clear or
     * current value of range is incorrect. At least the case of value reset for incorrect range should be fixed in addon.
     */
    public static void setCustomLocationValueOnLocationDialog(String locationValue) {
        By customLocationLocator = By.id(FIELD_ID_CUSTOM_LOCATION_ON_LOCATION_DIALOG);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_ID_OK_ON_LOCATION_DIALOG)));
        WebElement locationField = driver.findElement(customLocationLocator);
        replaceTextWith(locationValue, locationField);
//        clearFieldWithEndShiftHomeBackspace(locationField);
        sleep(5000);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//input[contains(@class, 'adx-input-error') and @id='inputActiveRangeSmall']")));
        locationField.sendKeys(locationValue);
        waitNameBoxValue(locationValue, 10, 1000);
        wait.until(ExpectedConditions.elementToBeClickable(By.id(BUTTON_ID_OK_ON_LOCATION_DIALOG)));
//        checkText(locationValue, FIELD_ID_CUSTOM_LOCATION_ON_LOCATION_DIALOG, CombineSheetsService::setCustomLocationValueOnLocationDialog);
    }




    public static void clickCustomLocationDialogButton()
    {
        clickElement(By.xpath(attributeIs("for", "toSmallWindowCustomLocationControl")));
    }


    public static void clickOKOnLocationDialog()
    {
        clickElement(BUTTON_ID_OK_ON_LOCATION_DIALOG);
    }


    public static void clickNext() {
        clickElement("combineSheetsNext");
    }


    public static void clickCombineAndClose() {
        clickCombine();
        waitForCompletionAndClose("have been successfully combined", BUTTON_ID_CLOSE);
    }

    public static void clickCombine() {
        clickElement(BUTTON_ID_COMBINE);
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

