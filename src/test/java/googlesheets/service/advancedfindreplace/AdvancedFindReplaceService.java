package googlesheets.service.advancedfindreplace;

import googlesheets.service.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static googlesheets.service.GoogleSheetService.*;
import static googlesheets.service.generic.GenericAddonService.switchDriverToAddonIframe;

public class AdvancedFindReplaceService {
    public static final String MENU_TEXT_ADVANCED_FIND_AND_REPLACE = "Advanced Find and Replace";
    public static final String MENU_TEXT_START = "Start";

    private static final WebDriver driver = WebDriverService.getInstance().getDriver();
    private static final WebDriverWait wait = WebDriverService.getInstance().getWait();


    public static void runAdvancedFindAndReplace() throws InterruptedException {
        clickAddonsMenu();
        clickAdvancedFindAndReplaceMenu();
        clickStartMenu();
        //todo: change to some explicit wait
        //wait for dialog window to be loaded
        Thread.sleep(5000);

        switchDriverToAddonIframe();
    }


    public static void setSearchString(String searchString) throws InterruptedException {
        By searchStringLocator = By.id("afrSearchString");
        wait.until(ExpectedConditions.presenceOfElementLocated(searchStringLocator));
        try {
            driver.findElement(searchStringLocator).clear();
            driver.findElement(searchStringLocator).sendKeys(searchString);
        }
        //todo: replace with some generic construction
        catch (ElementNotInteractableException e) {
            Thread.sleep(1000);
            setSearchString(searchString);
        }
    }



    private static void clickAdvancedFindAndReplaceMenu() {
        clickHighLevelMenuItem(MENU_TEXT_ADVANCED_FIND_AND_REPLACE, MENU_TEXT_START);
    }


    private static void clickStartMenu() throws InterruptedException {
        clickMenuItem(MENU_TEXT_START);
    }


    public static void setSearchIn(SearchInSelection searchIn, int... indexes)
    {

    }

    public static void clickFindAll()
    {

    }

    public static void runExportAllFoundEntries(){

    }

    public static void setMatchCase(boolean value) {
        setCheckboxValue(value,"afrMatchCase");
    }

    public static void setEntireCell(boolean value) {
        setCheckboxValue(value,"afrEntireCell");
    }

    public static void setByMask(boolean value) {
        setCheckboxValue(value,"afrByMask");
    }

    public static void setValues(boolean value) {
        setCheckboxValue(value,"afrValuesCheckbox");
    }

    public static void setFormulas(boolean value) {
        setCheckboxValue(value, "afrFormulasCheckbox");
    }

    public static void setNotes(boolean value) {
        setCheckboxValue(value,"afrNotesCheckbox");
    }

    public static void setHyperlinks(boolean value) {
        setCheckboxValue(value, "afrHyperlinksCheckbox");
    }

    public static void setErrors(boolean value) {
        setCheckboxValue(value,"afrErrorsCheckbox");
    }



}
