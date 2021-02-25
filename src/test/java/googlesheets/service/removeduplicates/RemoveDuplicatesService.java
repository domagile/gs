package googlesheets.service.removeduplicates;

import googlesheets.service.GlobalContext;
import googlesheets.service.WebDriverService;
import googlesheets.service.generic.GenericAddonService;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static googlesheets.service.GoogleSheetService.*;

public class RemoveDuplicatesService extends GenericAddonService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();

    public static final String MENU_TEXT_FIND_DUPLICATE_OR_UNIQUE_ROWS = "Find duplicate or unique rows";
    public static final String MENU_TEXT_REMOVE_DUPLICATES = "Remove Duplicates";
    public static final String BUTTON_ID_NEXT = "nextButton";
    public static final String CHECKBOX_ID_MY_TABLE_HAS_HEADERS = "rdTableHasHeaders";
    public static final String CHECKBOX_ID_CREATE_BACKUP_COPY = "rdSheetBackupCheckbox";


    public static void runFindDuplicateOrUniqueRows() throws InterruptedException {
        if (GlobalContext.IS_POWER_TOOLS_MODE) {
            runThroughPowerTools();
        } else {
            runAsSeparateAddon();
        }
    }


    public static void selectColumnsToSearchIn(Integer... indexes) throws InterruptedException {
        By checkboxLocator = By.className("rd-column-select-checkbox");
        selectRowsInTable("rdColumnsList", checkboxLocator, indexes);
    }


    private static void clickFindDuplicateOrUniqueRowsMenu() throws InterruptedException {
        clickMenuItem(MENU_TEXT_FIND_DUPLICATE_OR_UNIQUE_ROWS);
    }


    private static void clickRemoveDuplicatesMenu() {
        clickHighLevelMenuItem(MENU_TEXT_REMOVE_DUPLICATES, MENU_TEXT_FIND_DUPLICATE_OR_UNIQUE_ROWS);
    }

    public static void clickNext() throws InterruptedException {
        clickButton(BUTTON_ID_NEXT);
    }

    public static void setRange(String range) throws InterruptedException {
        By selectedRangeLocator = By.id("rdSelectedRange");
        wait.until(ExpectedConditions.presenceOfElementLocated(selectedRangeLocator));
        try {
            //fixme: replace with some check
            Thread.sleep(3000);
            driver.findElement(selectedRangeLocator).clear();
            driver.findElement(selectedRangeLocator).sendKeys(range);
            Thread.sleep(2000);
        } catch (ElementNotInteractableException e) {
            Thread.sleep(1000);
            setRange(range);
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

    public static void setCustomLocationRange(String range) throws InterruptedException {
        By selectedCustomLocationRange = By.id("rdExistingSheetRange");
        wait.until(ExpectedConditions.presenceOfElementLocated(selectedCustomLocationRange));
        try {
            //fixme: replace with some check
            driver.findElement(selectedCustomLocationRange).clear();
            driver.findElement(selectedCustomLocationRange).sendKeys(range);
            Thread.sleep(2000);
        } catch (ElementNotInteractableException e) {
            Thread.sleep(1000);
            setRange(range);
        }
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

    public static void clickCustomLocation() throws InterruptedException {
        clickRadioButton("rdPlaceExistingSheet");
        //wait until dynamic behavior assigns default range
        Thread.sleep(2000);
    }

    public static void clickMoveToAnotherLocation() {
        clickRadioButton("rdActionMove");
    }

    // Delete entire rows from the sheet

    public static void clickDeleteEntireRowsFromTheSheetRadioButton() {
        clickRadioButton("rdActionDeleteEntireRows");
    }


    public static void clickFinishAndClose() throws InterruptedException {
        driver.findElement(By.id("nextButton")).click();
        waitForCompletionAndClose();
    }


    public static void waitForCompletionAndClose() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[text()[contains(.,'rows have been found')]]")));

        clickButton("closeButton");

        driver.switchTo().defaultContent();
    }


    private static void runThroughPowerTools() throws InterruptedException {
        runPowerTools();

//        "dedupeTab"


    }


    private static void runPowerTools() throws InterruptedException {
        clickAddonsMenu();
        clickHighLevelMenuItem("Power Tools", "Start");
        clickMenuItem("Start");
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        Thread.sleep(5000);
        switchDriverToAddonIframe();
    }


    private static void runAsSeparateAddon() throws InterruptedException {
        clickAddonsMenu();
        clickRemoveDuplicatesMenu();
        clickFindDuplicateOrUniqueRowsMenu();
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        Thread.sleep(5000);

        switchDriverToAddonIframe();
    }
}
