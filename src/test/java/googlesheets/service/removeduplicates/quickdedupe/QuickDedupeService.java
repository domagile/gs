package googlesheets.service.removeduplicates.quickdedupe;

import googlesheets.model.rd.quickdedupe.QuickDedupeActionEnumeration;
import googlesheets.service.generic.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public class QuickDedupeService {
    public static final String CHECKBOX_ID_MY_TABLE_HAS_HEADRRS = "qdTableHasHeaders";
    public static final String CHECKBOX_ID_SKIP_EMPTY_CELLS = "qdSkipEmptyCells";
    public static final String CHECKBOX_ID_CREATE_BACKUP_COPY = "qdSheetBackupCheckbox";

    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();

    public static void setCreateBackupCopyOfSheet(boolean value) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id(CHECKBOX_ID_CREATE_BACKUP_COPY)));
        setCheckboxValue(value, CHECKBOX_ID_CREATE_BACKUP_COPY);
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
        driver.findElement(By.id("nextButton")).click();
        waitForCompletionAndClose();
    }


    public static void waitForCompletionAndClose() {
        wait.until(ExpectedConditions.presenceOfElementLocated(
                By.xpath("//*[text()[contains(.,'have been found')]]")));

        sleep(5000);
        clickElement("closeButton");

        driver.switchTo().defaultContent();
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
        WebElement combobox = driver.findElement(By.className("action-select"));
        selectComboboxValue(combobox, typeText);
    }

}
