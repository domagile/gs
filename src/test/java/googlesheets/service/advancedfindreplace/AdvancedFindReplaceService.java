package googlesheets.service.advancedfindreplace;

import googlesheets.service.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.function.Consumer;

import static googlesheets.service.GoogleSheetService.*;
import static googlesheets.service.generic.GenericAddonService.*;

public class AdvancedFindReplaceService {
    public static final String MENU_TEXT_ADVANCED_FIND_AND_REPLACE = "Advanced Find and Replace";
    //   public static final String MENU_TEXT_ADVANCED_FIND_AND_REPLACE = "Dev Scr";
    public static final String MENU_TEXT_START = "Start";

    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();
    public static final String BUTTON_ID_FIND_ALL = "afrFindActionButtonBottom";
    public static final String BUTTON_ID_REPLACE_ALL = "afrReplaceAllActionButton";
    public static final String BUTTON_ID_REPLACE = "afrReplaceActionButton";
    public static final String BUTTON_ID_NEW_SEARCH = "afrNewSearchButton";


    public static void runAdvancedFindAndReplace() throws InterruptedException {
        clickAddonsMenu();
        clickAdvancedFindAndReplaceMenu();
        clickStartMenu();
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        Thread.sleep(5000);

        switchDriverToAddonIframe();
    }

    public static void setSearchString(String searchString) {
        setText(searchString, "afrSearchString");
    }

    public static void setReplaceString(String replacementString) throws InterruptedException {
        setText(replacementString, "afrReplaceString");
    }


    private static void clickAdvancedFindAndReplaceMenu() {
        clickHighLevelMenuItem(MENU_TEXT_ADVANCED_FIND_AND_REPLACE, MENU_TEXT_START, false);
    }


    private static void clickStartMenu() throws InterruptedException {
        clickMenuItem(MENU_TEXT_START);
    }


    public static void setSearchIn(SearchInSelection searchIn, Integer... indexes) throws InterruptedException {
        switch (searchIn) {
            case SELECTED_LISTS:
                By checkboxLocator = By.tagName("input");
                selectRowsInTable("afrSheetsList", checkboxLocator, indexes);
                return;
            default:
                throw new UnsupportedOperationException(String.format("Selection type is not supported: %s", searchIn.toString()));
        }
    }

    public static void clickFindAll() throws InterruptedException {
        clickButton(BUTTON_ID_FIND_ALL);
    }

    public static void clickReplaceAll() throws InterruptedException {
        clickButton(BUTTON_ID_REPLACE_ALL);
    }

    public static void clickReplace() throws InterruptedException {
        clickButton(BUTTON_ID_REPLACE);
    }

    public static void clickNewSearch() throws InterruptedException {
        clickButton(BUTTON_ID_NEW_SEARCH);
    }

    public static void runExportAllFoundEntries() throws InterruptedException {
        clickButton("afrOptionOfResultMenuWrapper");
        clickMenuItem("Export all found entries");
    }

    public static void runExportRowsWithAllFoundEntries() throws InterruptedException {
        clickButton("afrOptionOfResultMenuWrapper");
        clickMenuItem("Export rows with all found entries");
    }

    public static void runDeleteRowsWithAllFoundEntries() throws InterruptedException {
        clickButton("afrOptionOfResultMenuWrapper");
        clickMenuItem("Delete rows with all found entries");
    }

    public static void runExportTheSelectedEntries() throws InterruptedException {
        clickButton("afrOptionOfResultMenuWrapper");
        clickMenuItem("Export the selected entries");
    }

    public static void runExportRowsWithTheSelectedEntries() throws InterruptedException {
        clickButton("afrOptionOfResultMenuWrapper");
        clickMenuItem("Export rows with the selected entries");
    }

    public static void runDeleteRowsWithTheSelectedEntries() throws InterruptedException {
        clickButton("afrOptionOfResultMenuWrapper");
        clickMenuItem("Delete rows with the selected entries");
    }


    public static void setMatchCase(boolean value) {
        setCheckboxValue(value, "afrMatchCase");
    }

    public static void setEntireCell(boolean value) {
        setCheckboxValue(value, "afrEntireCell");
    }

    public static void setByMask(boolean value) {
        setCheckboxValue(value, "afrByMask");
    }

    public static void setValues(boolean value) {
        setCheckboxValue(value, "afrValuesCheckbox");
    }

    public static void setFormulas(boolean value) {
        setCheckboxValue(value, "afrFormulasCheckbox");
    }

    public static void setNotes(boolean value) {
        setCheckboxValue(value, "afrNotesCheckbox");
    }

    public static void setHyperlinks(boolean value) {
        setCheckboxValue(value, "afrHyperlinksCheckbox");
    }

    public static void setErrors(boolean value) {
        setCheckboxValue(value, "afrErrorsCheckbox");
    }
}
