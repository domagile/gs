package googlesheets.service.removeduplicates.removeduplicatesrows;

import googlesheets.service.generic.addon.GenericAddonService;
import googlesheets.service.generic.google.GoogleSheetService;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebElement;

import static googlesheets.service.generic.addon.FunctionReinvocationUtil.reinvokeFunctionWithDelay;
import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.webdriver.FieldHelper.getPresentElement;

public class RemoveDuplicatesRowsService extends GenericAddonService {

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
        try {
            WebElement field = getPresentElement("rdSelectedRange");
            //fixme: replace with some check
            sleep(3000);
            field.clear();
            field.sendKeys(range);
            sleep(2000);
        } catch (ElementNotInteractableException e) {
            reinvokeFunctionWithDelay(RemoveDuplicatesRowsService::setRange, range);
        }
    }

    public static void setCreateBackupCopyOfSheet(boolean value) {
        setPresentCheckboxValue(CHECKBOX_ID_CREATE_BACKUP_COPY, value);
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
        setText("rdExistingSheetRange", range);
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
        clickFinish();
        waitForCompletionAndClose("been found", "closeButton");
    }


    public static void clickFillWithColor() {
        clickRadioButton("rdActionFillTheColor");
    }


    public static void clickFinish() {
        GoogleSheetService.clickElement(BUTTON_ID_NEXT);
    }
}
