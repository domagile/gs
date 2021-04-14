package googlesheets.ui.components;

import googlesheets.model.generic.ResultLocation;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.openqa.selenium.WebElement;

import static googlesheets.service.generic.addon.GenericAddonService.invokeFunctionWithReinvocation;
import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.xpath.XPathHelper.attributeIs;

public class ResultLocationPanel {
    private static final String FIELD_ID_CUSTOM_LOCATION = "txtCustomLocation";
    public static final String FIELD_ID_CUSTOM_LOCATION_ON_LOCATION_DIALOG = "inputActiveRangeSmall";
    public static final String BUTTON_ID_OK_ON_LOCATION_DIALOG = "btnSmallOk";

    private String nextButtonId;

    public ResultLocationPanel(String nextButtonId)
    {
        this.nextButtonId = nextButtonId;
    }


    public void selectResultLocation(ResultLocation resultLocation, String customLocationValue) {
        switch (resultLocation) {
            case NEW_SHEET:
                chooseStoreToNewSheet();
                break;
            case NEW_SPREADSHEET:
                chooseStoreToNewSpreadsheet();
                break;
            case CUSTOM_LOCATION:
                chooseStoreToCustomLocation();
                invokeFunctionWithReinvocation(this::setCustomLocationValue,
                        customLocationValue, InvalidElementStateException.class);
                //let "Invalid range" message disappear
                sleep(1000);
                break;
        }
    }


    private static void chooseStoreToNewSpreadsheet() {
        clickRadioButton("place0");
    }


    private static void chooseStoreToNewSheet() {
        clickRadioButton("place1");
    }


    public static void chooseStoreToCustomLocation() {
        clickRadioButton("place2");
    }


    public static void waitForCustomLocationValue(String value)
    {
        waitForCondition(() -> getCustomLocationField().getText().equals(value), 10, 1000);
    }


    public static void clickCustomLocationValueField()
    {
        getCustomLocationField().click();
    }


    private void setCustomLocationValue(String locationValue) {
        WebElement customLocationField = getCustomLocationField();
        waitElementToBeClickable(customLocationField);
        customLocationField.clear();
        customLocationField.sendKeys(locationValue);
        waitElementToBeClickable(nextButtonId);
        checkText(locationValue, FIELD_ID_CUSTOM_LOCATION, this::setCustomLocationValue);
    }

    private static WebElement getCustomLocationField() {
        return getElement(FIELD_ID_CUSTOM_LOCATION);
    }


    public static void clickCustomLocationDialogButton()
    {
        clickElement(By.xpath(attributeIs("for", "toSmallWindowCustomLocationControl")));
    }


    public static void clickOKOnLocationDialog()
    {
        clickElement(BUTTON_ID_OK_ON_LOCATION_DIALOG);
    }
}
