package googlesheets.service.removeduplicates.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.webdriver.FieldHelper.getElement;
import static googlesheets.service.generic.webdriver.FieldHelper.getElementByClassName;
import static googlesheets.service.generic.webdriver.WebDriverService.switchDriverToDefaultContent;

public class QuickDedupeService {
    public static final String CHECKBOX_ID_MY_TABLE_HAS_HEADRRS = "qdTableHasHeaders";
    public static final String CHECKBOX_ID_SKIP_EMPTY_CELLS = "qdSkipEmptyCells";
    public static final String CHECKBOX_ID_CREATE_BACKUP_COPY = "qdSheetBackupCheckbox";


    public static void setCreateBackupCopyOfSheet(boolean value) {
        setPresentCheckboxValue(CHECKBOX_ID_CREATE_BACKUP_COPY, value);
        sleep(5000);
    }


    public static void setSkipEmptyCells(boolean value) {
        setCheckboxValue(value, "qdSkipEmptyCells");
    }

    public static void setTableHasHeaders(boolean value) {
        setCheckboxValue(value, CHECKBOX_ID_MY_TABLE_HAS_HEADRRS);
    }

    public static void runQuickDedupe() {
        new QuickDedupeRunner().runAddon();
    }

    public static void selectColumnsToSearchIn(List<Integer> indexes) {
        By checkboxLocator = By.tagName("input");
        selectRowsInTable("qdColumnsList", checkboxLocator, indexes);
    }


    public static void clickFinishAndClose() {
        getElement("nextButton").click();
        waitForCompletionAndClose();
    }


    public static void waitForCompletionAndClose() {
        waitText("have been found");

        sleep(5000);
        clickElement("closeButton");

        switchDriverToDefaultContent();
    }


    public static void selectAction(QuickDedupeActionEnumeration action) {
        String typeText;
        switch (action) {
            case FILL_WITH_COLOR:
                typeText = "Fill with color";
                break;
            case DELETE_ROWS_WITHIN_SELECTION:
                typeText = "Delete rows within selection";
                break;
            case DELETE_ENTIRE_ROWS_ON_THE_SHEET:
                typeText = "Delete entire rows on the sheet";
                break;
            case ADD_STATUS_COLUMN:
                typeText = "Add a status column";
                break;
            case CLEAR_VALUES:
                typeText = "Clear values";
                break;
            case COPY_TO_A_NEW_SHEET:
                typeText = "Copy to a new sheet";
                break;
            case MOVE_TO_A_NEW_SHEET:
                typeText = "Move to a new sheet";
                break;
            default:
                throw new IllegalArgumentException("Unknown cell type: " + action);
        }
        WebElement combobox = getElementByClassName("action-select");
        selectComboboxValue(combobox, typeText);
    }

}
