package googlesheets.service.removeduplicates.comparetwosheets;

import googlesheets.service.generic.addon.sheetselection.EntityList;
import googlesheets.service.generic.WebDriverService;
import googlesheets.service.generic.addon.GenericAddonService;
import googlesheets.service.generic.google.GoogleSheetService;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public class CompareTwoSheetsService extends GenericAddonService {
    public static final String CHECKBOX_ID_CREATE_BACKUP_COPY = "rdSheetBackupCheckbox";
    public static final String BUTTON_ID_NEXT = "nextButton";
    public static final String BUTTON_ID_AUTO_DETECT = "ctsAutoDetectColumnButton";
    public static final String CHECKBOX_ID_TABLE1_HAS_HEADERS = "rdTableHasHeaders";
    public static final String CHECKBOX_ID_TABLE2_HAS_HEADERS = "ctsTableHasHeaders";


    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();


    public static void runCompareColumnsOrSheets() {
        new CompareTwoSheetsRunner().runAddon();
    }

    public static void setCreateBackupCopyOfSheet(boolean value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(CHECKBOX_ID_CREATE_BACKUP_COPY)));
        setCheckboxValue(value, CHECKBOX_ID_CREATE_BACKUP_COPY);
        sleep(5000);
    }

    public static void clickNext() {
        clickElement(BUTTON_ID_NEXT);
    }

    public static void waitNextButtonEnabled() {
//        wait.until(ExpectedConditions.)
    }

    public static void clickAutoDetect() {
        clickElement(BUTTON_ID_AUTO_DETECT);
    }

    public static void setStep1Range(String range) {
        setRange(range, "rdSelectedRange");
    }

    public static void setStep2Range(String range) {
        //do not set range before loading of field of second sheet to avoid freeze
        waitNextButtonEnabled();
        sleep(10000);
        setRange(range, "ctsSelectedRange");
    }


    public static void setRangeExistingSheet(String range) {
        setRange(range, "rdExistingSheetRange");
    }

    private static void setRange(String range, String rangeFieldId) {
        By selectedRangeLocator = By.id(rangeFieldId);
        wait.until(ExpectedConditions.presenceOfElementLocated(selectedRangeLocator));
        try {
            //fixme: replace with some check
            sleep(3000);
            driver.findElement(selectedRangeLocator).clear();
            driver.findElement(selectedRangeLocator).sendKeys(range);
            sleep(2000);
            checkText(range, rangeFieldId, CompareTwoSheetsService::setRange);
        } catch (ElementNotInteractableException e) {
            sleep(1000);
            setRange(range, rangeFieldId);
        }
    }


    public static void clickDuplicateValuesRadioButton() {
        clickRadioButton("rdDuplicateRadio");
    }

    public static void clickUniqueValuesRadioButton() {
        clickRadioButton("rdUniqueRadio");
    }

    public static void setTable1HasHeaders(boolean value) {
        setCheckboxValue(value, CHECKBOX_ID_TABLE1_HAS_HEADERS);
    }

    public static void setTable2HasHeaders(boolean value) {
        setCheckboxValue(value, CHECKBOX_ID_TABLE2_HAS_HEADERS);
    }

    public static void setSkipEmptyCells(boolean value) {
        setCheckboxValue(value, "rdSkipEmptyCells");
    }

    public static void setMatchCase(boolean value) {
        setCheckboxValue(value, "rdCaseSensitive");
    }


    public static void selectColumnsToSearchIn(Integer... indexes) {
        By checkboxLocator = By.className("rd-column-select-checkbox");
        selectRowsInTable("rdColumnsList", checkboxLocator, indexes);
    }


    // проверить id
    public static void clickAddStatusColumnRadioButton() {
        clickRadioButton("rdActionAddStatusCol");
    }

    public static void clickClearValuesRadioButton() {
        clickRadioButton("rdActionClearValues");
    }

    public static void clickDeleteRowsWithinSelectionRadioButton() {
        clickRadioButton("rdActionDeleteValues");
    }

    public static void clickCopyToAnotherLocation() {
        clickRadioButton("rdActionCopy");
    }

    public static void clickNewSheet() {
        clickRadioButton("rdPlaceNewSheet");
    }

    public static void clickExistingSheet() {
        clickRadioButton("rdPlaceExistingSheet");
    }

    public static void clickNewSpreadsheet() {
        clickRadioButton("rdPlaceNewSpreadsheet");
    }

    public static void clickCustomLocation() {
        clickRadioButton("rdPlaceExistingSheet");
        //wait until dynamic behavior assigns default range
        sleep(2000);
    }

    public static void clickMoveToAnotherLocation() {
        clickRadioButton("rdActionMove");
    }

    // Delete entire rows from the sheet

    public static void clickDeleteEntireRowsFromTheSheetRadioButton() {
        clickRadioButton("rdActionDeleteEntireRows");
    }


    public static void clickFinishAndClose() {
        driver.findElement(By.id("nextButton")).click();
        waitForCompletionAndClose();
    }


    public static void waitForCompletionAndClose() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[text()[contains(.,'have been found')]]")));
        //
        sleep(5000);
        clickElement("closeButton");

        driver.switchTo().defaultContent();
    }


    public static void setColumnsToCompare(ColumnComparisonPair... pairs) {
        By checkboxLocator = By.tagName("input");
        selectPairsInTable("rdColumnsList", checkboxLocator, pairs);
    }


    private static void selectPairsInTable(String tableBodyId, By checkboxLocator, ColumnComparisonPair... pairs) {
        try {
            By comboboxLocator = By.tagName("select");
            wait.until(ExpectedConditions.presenceOfElementLocated(By.id(tableBodyId)));
            WebElement tBody = driver.findElement(By.id(tableBodyId));
            List<WebElement> trs = tBody.findElements(By.tagName("tr"));
            //if list is loaded during long time
            while (trs.isEmpty()) {
                sleep(1000);
                trs = tBody.findElements(By.tagName("tr"));
            }
            EntityList columns = new EntityList(trs, 0);
            List<ColumnComparisonPair> pairList = Arrays.asList(pairs);
            for (ColumnComparisonPair pair : pairList) {
                columns.selectEntity(pair.getFirstTableColumnIndex() - 1, true, checkboxLocator);
                columns.setComboboxValue(pair.getFirstTableColumnIndex() - 1, 3, pair.getSecondTableColumnName(), comboboxLocator);
            }
        }
        //when tBody is reloaded by browser and link is not actual
        catch (StaleElementReferenceException e) {
            selectPairsInTable(tableBodyId, checkboxLocator, pairs);
        }
    }


    public static void selectSecondSheet(String sheetName)  {
        selectComboboxValue("ctsSheetSelect", sheetName);
    }

    public static void selectExistingSheet(String sheetName)  {
        selectComboboxValue("rdExistingSheetSelect", sheetName);
    }

    public static void clickFillWithColor() {
        clickRadioButton("rdActionFillTheColor");
    }


    //fixme: doesn't work by some reason - chosen color is not applied, displayed color is applied instead. try to change style of the div?
    public static void setColor(String colorCode)
    {
//        WebElement colorInput = driver.findElement(By.id("rdActionFillTheColorInput"));
        WebElement colorInput = driver.findElement(By.className("choise_color"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='"+ colorCode + "';", colorInput);
    }


    public static void clickFinish() {
        GoogleSheetService.clickElement(BUTTON_ID_NEXT);
    }
}
