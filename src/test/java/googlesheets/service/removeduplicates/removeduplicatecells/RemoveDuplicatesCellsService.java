package googlesheets.service.removeduplicates.removeduplicatecells;

import googlesheets.service.generic.WebDriverService;
import googlesheets.service.generic.addon.GenericAddonService;
import googlesheets.service.generic.google.GoogleSheetService;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public class RemoveDuplicatesCellsService extends GenericAddonService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();

    public static final String BUTTON_ID_NEXT = "nextButton";
    public static final String CHECKBOX_ID_CREATE_BACKUP_COPY = "rdSheetBackupCheckbox";
    public static final String TEXTFIELD_ID_CUSTOM_LOCATION_RANGE = "rdExistingSheetRange";


    public static void runFindDuplicateOrUniqueCells() {
        new RemoveDuplicatesCellsRunner().runAddon();
    }


    public static void setSkipEmptyCells(boolean value) {
        setCheckboxValue(value, "rdSkipEmptyCells");
    }

    public static void setMatchCase(boolean value) {
        setCheckboxValue(value, "rdCaseSensitive");
    }

    public static void clickNext() {
        GoogleSheetService.clickElement(BUTTON_ID_NEXT);
    }

    public static void clickFinish() {
        GoogleSheetService.clickElement(BUTTON_ID_NEXT);
    }

    public static void setRange(String range) {
        By selectedRangeLocator = By.id("rdSelectedRange");
        wait.until(ExpectedConditions.presenceOfElementLocated(selectedRangeLocator));
        try {
            //fixme: replace with some check
            sleep(3000);
            driver.findElement(selectedRangeLocator).clear();
            driver.findElement(selectedRangeLocator).sendKeys(range);
            sleep(2000);
        } catch (ElementNotInteractableException e) {
            reinvokeFunctionWithDelay(RemoveDuplicatesCellsService::setRange, range);
        }
    }

    public static void setCreateBackupCopyOfSheet(boolean value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(CHECKBOX_ID_CREATE_BACKUP_COPY)));
//        WebElement checkbox = driver.findElement(By.id(CHECKBOX_ID_CREATE_BACKUP_COPY));
//        if (checkbox.isSelected() != value) {
//            checkbox.click();
//        }
        setCheckboxValue(value, CHECKBOX_ID_CREATE_BACKUP_COPY);
    }


    public static void clickCopyToAnotherLocation() {
        clickRadioButton("rdActionCopy");
    }

    public static void clickFillWithColor() {
        clickRadioButton("rdActionFillTheColor");
    }


    //fixme: doesn't work by some reason - chosen color is not applied, displayed color is applied instead. try to change style of the div?
    public static void setColor(String colorCode) {
//        WebElement colorInput = driver.findElement(By.id("rdActionFillTheColorInput"));
        WebElement colorInput = driver.findElement(By.className("choise_color"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].value='" + colorCode + "';", colorInput);
    }

    public static void clickNewSheet() {
        clickRadioButton("rdPlaceNewSheet");
    }

    public static void clickNewSpreadsheet() {
        clickRadioButton("rdPlaceNewSpreadsheet");
    }

    public static void clickCustomLocation() {
        clickRadioButton("rdPlaceExistingSheet");
        //wait until dynamic behavior assigns default range
        sleep(2000);
    }

    public static void setCustomLocationRange(String range) {
        setText(range, TEXTFIELD_ID_CUSTOM_LOCATION_RANGE);
        //todo: instead of sleep it's needed to check status of the tab: from tab label 4 divs up and check specific class of div
        sleep(2000);
        checkText(range, TEXTFIELD_ID_CUSTOM_LOCATION_RANGE, RemoveDuplicatesCellsService::setCustomLocationRange);
    }


    public static void clickMoveToAnotherLocation() {
        clickRadioButton("rdActionMove");
    }

    public static void clickClearValuesRadioButton() {
        clickRadioButton("rdActionClearValues");
    }


    public static void selectColumnsToSearchIn(Integer... indexes) {
        By checkboxLocator = By.className("rd-column-select-checkbox");
        selectRowsInTable("rdColumnsList", checkboxLocator, indexes);
    }


    public static void clickFinishAndClose() {
        clickFinish();
        waitForCompletionAndClose("values have been found", "closeButton");
    }


    public static void selectCellType(CellType cellType) {
        String typeText;
        switch (cellType) {
            case DUPLICATES:
                typeText = "Duplicates";
                break;
            case DUPLICATES_FIRST_OCCURRENCES:
                typeText = "Duplicates + 1st occurrences";
                break;
            case UNIQUES:
                typeText = "Uniques";
                break;
            case UNIQUES_FIRST_OCCURRENCES:
                typeText = "Uniques + 1st occurrences";
                break;
            default:
                throw new IllegalArgumentException("Unknown cell type: " + cellType);
        }
        selectComboboxValue("fdcFindSelectInternal", typeText);
    }

}
