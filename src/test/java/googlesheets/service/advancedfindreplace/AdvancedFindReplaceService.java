package googlesheets.service.advancedfindreplace;

import googlesheets.model.advancedfindreplace.AFRActionEnumeration;
import googlesheets.service.generic.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static googlesheets.service.generic.addon.GenericAddonService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;

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


    public static void runAdvancedFindAndReplace() {
        clickAddonsMenu();
        clickAdvancedFindAndReplaceMenu();
        clickStartMenu();
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        sleep(5000);

        switchDriverToAddonIframe();
    }

    public static void setSearchString(String searchString) {
        setText(searchString, "afrSearchString");
    }


    public static void setReplaceString(String replacementString) {
        setText(replacementString, "afrReplaceString");
    }


    private static void clickAdvancedFindAndReplaceMenu() {
        clickHighLevelMenuItem(MENU_TEXT_ADVANCED_FIND_AND_REPLACE, MENU_TEXT_START, false);
    }


    private static void clickStartMenu() {
        clickMenuItem(MENU_TEXT_START);
    }


    public static void setSearchIn(SearchInSelection searchIn, List<Integer> indexes) {
        switch (searchIn) {
            case SELECTED_LISTS:
                By checkboxLocator = By.tagName("input");
                selectRowsInTable("afrSheetsList", checkboxLocator, indexes);
                return;
            default:
                throw new UnsupportedOperationException(String.format("Selection type is not supported: %s", searchIn.toString()));
        }
    }

    public static void clickFindAll() {
        clickElement(BUTTON_ID_FIND_ALL);
    }

    public static void clickReplaceAll() {
        clickElement(BUTTON_ID_REPLACE_ALL);
    }

    public static void clickReplace() {
        clickElement(BUTTON_ID_REPLACE);
    }

    public static void clickNewSearch() {
        clickElement(BUTTON_ID_NEW_SEARCH);
    }


    public static void runMenuAction(AFRActionEnumeration action) {
        runMenuAction(action, -1);
    }

    public static void runMenuAction(AFRActionEnumeration action, int timeoutSec) {
        clickElement("afrOptionOfResultMenuWrapper");
        clickMenuItem(action.getMenuText());
        if (timeoutSec == -1) {
            waitForWorkingMessageDisplayedAndHidden();
        }
        else {
            waitForWorkingMessageDisplayedAndHidden(timeoutSec);
        }
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
