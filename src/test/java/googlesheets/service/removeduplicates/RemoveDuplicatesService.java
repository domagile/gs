package googlesheets.service.removeduplicates;

import googlesheets.service.WebDriverService;
import googlesheets.service.combinesheets.EntityList;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.List;

import static googlesheets.service.GoogleSheetService.*;
import static googlesheets.service.generic.GenericAddonService.switchDriverToAddonIframe;

public class RemoveDuplicatesService {
    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();

    public static final String MENU_TEXT_FIND_DUPLICATE_OR_UNIQUE_ROWS = "Find duplicate or unique rows";
    public static final String MENU_TEXT_REMOVE_DUPLICATES = "Remove Duplicates";
    public static final String BUTTON_ID_NEXT = "nextButton";
    public static final String CHECKBOX_ID_MY_TABLE_HAS_HEADERS = "rdTableHasHeaders";
    public static final String CHECKBOX_ID_CREATE_BACKUP_COPY = "rdSheetBackupCheckbox";


    public static void runFindDuplicateOrUniqueRows() throws InterruptedException {
        clickAddonsMenu();
        clickRemoveDuplicatesMenu();
        clickFindDuplicateOrUniqueRowsMenu();
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        Thread.sleep(5000);

        switchDriverToAddonIframe();
    }


    public static void selectColumnsToSearchIn(Integer... indexes) throws InterruptedException {
        WebElement tBody = driver.findElement(By.id("rdColumnsList"));
        List<WebElement> trs = tBody.findElements(By.tagName("tr"));
        //if list is loaded during long time
        while (trs.isEmpty()) {
            Thread.sleep(1000);
            trs = tBody.findElements(By.tagName("tr"));
        }
        EntityList columns = new EntityList(trs, 0);
        List indexList = Arrays.asList(indexes);
        for (int i = 0; i < trs.size(); i++) {
            columns.selectEntity(i, indexList.contains(i + 1));
        }
    }


    private static void clickFindDuplicateOrUniqueRowsMenu() throws InterruptedException {
        clickMenuItem(MENU_TEXT_FIND_DUPLICATE_OR_UNIQUE_ROWS);
    }


    private static void clickRemoveDuplicatesMenu() {
        clickHighLevelMenuItem(MENU_TEXT_REMOVE_DUPLICATES, MENU_TEXT_FIND_DUPLICATE_OR_UNIQUE_ROWS);
    }

    //fixme: create generic method to click buttons
    public static void clickNext() throws InterruptedException {
        try {
            By nextButton = By.id(BUTTON_ID_NEXT);
            wait.until(ExpectedConditions.elementToBeClickable(nextButton));
            driver.findElement(nextButton).click();
        } catch (InvalidElementStateException | TimeoutException e) {
            Thread.sleep(1000);
            clickNext();
        }
    }

    public static void clickUndo() throws InterruptedException {
        driver.findElement(By.id("t-undo")).findElement(By.className("goog-toolbar-button-inner-box")).click();
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
        }
        catch (ElementNotInteractableException e) {
            Thread.sleep(1000);
            setRange(range);
        }
    }

    public static void setCreateBackupCopyOfSheet(boolean value)
    {
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


    private static void clickButton(String id) throws InterruptedException {
        try {
            By button = By.id(id);
            wait.until(ExpectedConditions.elementToBeClickable(button));
            driver.findElement(button).click();
        } catch (ElementClickInterceptedException e) {
            Thread.sleep(1000);
            clickButton(id);
        }
    }
}
