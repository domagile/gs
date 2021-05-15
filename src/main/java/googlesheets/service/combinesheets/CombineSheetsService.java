package googlesheets.service.combinesheets;

import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.ui.components.ResultLocationPanel;
import googlesheets.ui.components.SheetSelectionPanel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static googlesheets.service.generic.addon.GenericAddonService.waitForCompletionAndClose;
import static googlesheets.service.generic.addon.GenericAddonService.waitNameBoxValue;
import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.webdriver.FieldHelper.*;
import static googlesheets.service.generic.xpath.XPathHelper.attributeIs;

public class CombineSheetsService {

    public static final String BUTTON_ID_CLOSE = "combineSheetsClose";
    public static final String BUTTON_ID_COMBINE = "combineSheetsNext";
    public static final String FIELD_ID_CUSTOM_LOCATION_ON_LOCATION_DIALOG = "inputActiveRangeSmall";
    public static final String BUTTON_ID_OK_ON_LOCATION_DIALOG = "btnSmallOk";


    public static void selectHowToCopyDataOptions(CombineSheetsOptions options) {
        setConsiderTableHeaders(options.isConsiderTableHeaders());
        setUseFormulaToCombineSheets(options.isUseFormula());
        setPreserveFormatting(options.isPreserveFormatting());
        setSeparateByBlankRow(options.isSeparateByBlankRow());
    }


    public static void selectResultLocation(CombineSheetsOptions options) {
        new ResultLocationPanel(BUTTON_ID_COMBINE)
                .selectResultLocation(options.getResultLocation(), options.getCustomLocationValue());
    }


    public static void selectSheetsToCombine(CombineSheetsOptions options)
    {
        new SheetSelectionPanel().selectSheets(options);
    }


    public static void chooseStoreToCustomLocation() {
        ResultLocationPanel.chooseStoreToCustomLocation();
    }


    /**
     * clear() method shouldn't be used: it removes focus and corresponding listener of addon is invoked
     * and we have conflict between behaviour of test and addon
     *
     * Finally there is a mess of approaches below what could be used or waited and so on to try to get it work.
     * For all the cases focus is lost after sendKeys and value is reset to selected cell if the field is clear or
     * current value of range is incorrect. At least the case of value reset for incorrect range should be fixed in addon.
     */
    public static void setCustomLocationValueOnLocationDialog(String locationValue) {
        WebElement locationField = getClickableElement(FIELD_ID_CUSTOM_LOCATION_ON_LOCATION_DIALOG);
        replaceTextWith(locationValue, locationField);
//        clearFieldWithEndShiftHomeBackspace(locationField);
        sleep(5000);
        waitElementPresentByXpath("//input[contains(@class, 'adx-input-error') and @id='inputActiveRangeSmall']");
        locationField.sendKeys(locationValue);
        waitNameBoxValue(locationValue, 10, 1000);
        waitElementClickable(BUTTON_ID_OK_ON_LOCATION_DIALOG);
//        checkText(locationValue, FIELD_ID_CUSTOM_LOCATION_ON_LOCATION_DIALOG, CombineSheetsService::setCustomLocationValueOnLocationDialog);
    }




    public static void clickCustomLocationDialogButton()
    {
        clickElement(By.xpath(attributeIs("for", "toSmallWindowCustomLocationControl")));
    }


    public static void clickOKOnLocationDialog()
    {
        clickElement(BUTTON_ID_OK_ON_LOCATION_DIALOG);
    }


    public static void clickNext() {
        clickElement("combineSheetsNext");
    }


    public static void clickCombineAndClose() {
        clickCombine();
        waitForCompletionAndClose("have been successfully combined", BUTTON_ID_CLOSE);
    }

    public static void clickCombine() {
        clickElement(BUTTON_ID_COMBINE);
    }


    private static void setConsiderTableHeaders(boolean value) {
        setCheckboxValue(value, "bSheetHasHeaders");
    }


    private static void setSeparateByBlankRow(boolean value) {
        setCheckboxValue(value, "bSeparate");
    }


    private static void setUseFormulaToCombineSheets(boolean value) {
        setCheckboxValue(value, "bInsertFormula");
    }


    private static void setPreserveFormatting(boolean value) {
        setCheckboxValue(value, "bPreserveFormatting");
    }
}

