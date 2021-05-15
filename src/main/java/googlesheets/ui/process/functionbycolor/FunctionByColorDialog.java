package googlesheets.ui.process.functionbycolor;

import googlesheets.model.process.functionbycolor.CalculationModeEnumeration;
import googlesheets.model.process.functionbycolor.FunctionByColorEnumeration;
import org.openqa.selenium.WebElement;

import static googlesheets.service.generic.addon.GenericAddonService.switchDriverToFirstAddonIframe;
import static googlesheets.service.generic.addon.GenericAddonService.switchDriverToSecondAddonIframe;
import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.webdriver.FieldHelper.getElementByClassName;

public class FunctionByColorDialog {
    private static final String FIELD_ID_RANGE = "fbcSourceRange";
    private static final String FIELD_ID_RESULT_RANGE = "fbcDestCell";

    public void setRange(String range) {
        setText(FIELD_ID_RANGE, range);
        sleep(3000);
        checkText(range, FIELD_ID_RANGE, this::setRange);
    }


    public void setFontColorOption(boolean value) {
        setCheckboxValueByLabelClick("fbcFontColor", value);
    }


    public void setFontColorValue(String colorName) {
        setColor(colorName, "Font color", "fbc-font-color-picker");
    }


    public void setBackgroundColorOption(boolean value) {
        setCheckboxValueByLabelClick("fbcBgColor", value);
    }


    public void setBackgroundColorValue(String colorName) {
        setColor(colorName, "Background color", "fbc-bg-color-picker");
    }


    public void setFunction(FunctionByColorEnumeration function) {
        selectComboboxValue("selectFucntionsInternal", function.getText());
    }


    public void setResultRange(String range) {
        setText(FIELD_ID_RESULT_RANGE, range);
        sleep(3000);
        checkText(range, FIELD_ID_RESULT_RANGE, this::setResultRange);
    }


    public void expandHiddenOptions() {
        WebElement div = getElementByClassName("fbc-toggle-container");
        if (div.getAttribute("class").contains("fbc-hidden")) {
            clickElement(getElementByClassName("fbc-arrow-toggle"));
        }
    }


    public void setCalculationMode(CalculationModeEnumeration mode) {
        selectComboboxValue("selectInsertDestinationInternal", mode.getText());
    }


    public void setFillResultsWithColors(boolean value) {
        setCheckboxValueByLabelClick("fbcFillResults", value);
    }


    public void clickInsertFunctionButton() {
        clickElement("functionByColorActionButton");
    }


    public void clickPatternCellIcon() {
        clickElement("fbcPatternCell");
    }


    public void setColorCell(String cell) {
        switchDriverToSecondAddonIframe();
        setText("inputActiveRange", cell);
        clickElement("btnOk");
        switchDriverToFirstAddonIframe();
    }
}
