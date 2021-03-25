package googlesheets.service.removeduplicates.removeduplicatesrows;

import googlesheets.service.generic.WebDriverService;
import googlesheets.service.generic.addon.GenericAddonService;
import googlesheets.service.generic.google.GoogleSheetService;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public class RemoveDuplicatesRowsService extends GenericAddonService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();

    public static final String BUTTON_ID_NEXT = "nextButton";
    public static final String CHECKBOX_ID_MY_TABLE_HAS_HEADERS = "rdTableHasHeaders";
    public static final String CHECKBOX_ID_CREATE_BACKUP_COPY = "rdSheetBackupCheckbox";


    public static void runFindDuplicateOrUniqueRows() {
        new RemoveDuplicatesRowsRunner().runAddon();
    }


    public static void selectColumnsToSearchIn(Integer... indexes) {
        By checkboxLocator = By.className("rd-column-select-checkbox");
        selectRowsInTable("rdColumnsList", checkboxLocator, indexes);
    }


    public static void clickNext() {
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
            reinvokeFunctionWithDelay(RemoveDuplicatesRowsService::setRange, range);
        }
    }

    public static void setCreateBackupCopyOfSheet(boolean value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(CHECKBOX_ID_CREATE_BACKUP_COPY)));
        setCheckboxValue(value, CHECKBOX_ID_CREATE_BACKUP_COPY);
    }

    public static void clickDuplicatesRadioButton() {
        clickRadioButton("rdDuplicateRadio");
    }

    public static void clickDuplicatesAnd1stOccurrencesRadioButton() {
        clickRadioButton("rdDuplicateAndFirstRadio");
    }

    public static void clickUniquesRadioButton() {
        clickRadioButton("rdUniqueRadio");
    }

    public static void clickUniquesAnd1stOccurrencesRadioButton() {
        clickRadioButton("rdUniqueAndFirstRadio");
    }


    public static void setSkipEmptyCells(boolean value) {
        setCheckboxValue(value, "rdSkipEmptyCells");
    }

    public static void setMyTableHasHeaders(boolean value) {
        setCheckboxValue(value, CHECKBOX_ID_MY_TABLE_HAS_HEADERS);
    }

    public static void setMatchCase(boolean value) {
        setCheckboxValue(value, "rdCaseSensitive");
    }


    public static void clickAddStatusColumnRadioButton() {
        clickRadioButton("rdActionAddStatusCol");
    }

    public static void clickClearValuesRadioButton() {
        clickRadioButton("rdActionClearValues");
    }

    public static void clickDeleteRowsWithinSelectionRadioButton() {
        clickRadioButton("rdActionDeleteValues");
    }

    public static void setCustomLocationRange(String range) {
        setText(range, "rdExistingSheetRange");
        sleep(2000);
    }

    public static void clickCopyToAnotherLocation() {
        clickRadioButton("rdActionCopy");
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
                By.xpath("//*[text()[contains(.,'rows have been found')]]")));

        GoogleSheetService.clickElement("closeButton");

        driver.switchTo().defaultContent();
    }
}
