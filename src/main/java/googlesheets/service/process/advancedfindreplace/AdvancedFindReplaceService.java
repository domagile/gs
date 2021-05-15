package googlesheets.service.process.advancedfindreplace;

import googlesheets.model.process.advancedfindreplace.AFRActionEnumeration;
import googlesheets.service.generic.xpath.XPathHelper;
import org.openqa.selenium.By;

import java.util.List;

import static googlesheets.service.generic.addon.GenericAddonService.waitForWorkingMessageDisplayedAndHidden;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class AdvancedFindReplaceService {
    public static final String BUTTON_ID_FIND_ALL = "afrFindActionButtonBottom";
    public static final String BUTTON_ID_REPLACE_ALL = "afrReplaceAllActionButton";
    public static final String BUTTON_ID_REPLACE = "afrReplaceActionButton";
    public static final String BUTTON_ID_NEW_SEARCH = "afrNewSearchButton";


    public static void runAdvancedFindAndReplace() {
        new AdvancedFindReplaceRunner().runAddon();
    }

    public static void setSearchString(String searchString) {
        setText("afrSearchString", searchString);
    }


    public static void setReplaceString(String replacementString) {
        setText("afrReplaceString", replacementString);
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

    public static void selectedEntries(String text) {
        clickElement(By.xpath(XPathHelper.textContains("Master", "td")));
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
