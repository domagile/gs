package googlesheets.service.removeduplicates.removeduplicatesrows;

import googlesheets.service.GlobalContext;
import googlesheets.service.GoogleSheetService;
import googlesheets.service.WebDriverService;
import googlesheets.service.generic.IFrameInfo;
import googlesheets.service.removeduplicates.generic.RemoveDuplicatesService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static googlesheets.service.GoogleSheetService.*;

public class RemoveDuplicatesRowsService extends RemoveDuplicatesService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();

    public static final String MENU_TEXT_FIND_DUPLICATE_OR_UNIQUE_ROWS = "Find duplicate or unique rows";
    public static final String BUTTON_ID_NEXT = "nextButton";
    public static final String CHECKBOX_ID_MY_TABLE_HAS_HEADERS = "rdTableHasHeaders";
    public static final String CHECKBOX_ID_CREATE_BACKUP_COPY = "rdSheetBackupCheckbox";


    public static void runFindDuplicateOrUniqueRows() {
        if (GlobalContext.IS_POWER_TOOLS_MODE) {
            runThroughPowerTools();
        } else {
            runAsSeparateAddon();
        }
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


    private static void runThroughPowerTools() {
        IFrameInfo iFrameInfo = runPowerTools();
        clickElement("imageDedupeTab");
        //fixme: no reaction to click without this delay
        sleep(2000);
        clickElement("power-tools-data-remove-duplicate");
        final Logger logger = LogManager.getLogger();
        Configurator.setLevel(logger.getName(), Level.DEBUG);
        switchDriverToAddonIframe(iFrame -> {
            logger.debug("!!!!!!!!!!!!!!" + iFrame.getAttribute("src"));
            logger.debug("!!!!!!!!!!!!!!" + iFrameInfo.getTopIframeSrc());
            return !iFrame.getAttribute("src").equals(iFrameInfo.getTopIframeSrc());});
    }


    private static IFrameInfo runPowerTools() {
        clickAddonsMenu();
        clickHighLevelMenuItem("Power Tools", "Start");
        clickMenuItem("Start");
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        sleep(5000);
        return switchDriverToAddonIframe();
    }


    private static void runAsSeparateAddon() {
        runAddonThroughMenu(MENU_TEXT_FIND_DUPLICATE_OR_UNIQUE_ROWS);
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        sleep(5000);

        switchDriverToAddonIframe();
    }
}
