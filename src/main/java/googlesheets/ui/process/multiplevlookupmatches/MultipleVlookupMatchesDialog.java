package googlesheets.ui.process.multiplevlookupmatches;

import googlesheets.model.process.multiplevlookupmatches.RowReturnTypeEnumeration;
import googlesheets.service.generic.webdriver.FieldHelper;
import org.openqa.selenium.By;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public class MultipleVlookupMatchesDialog {
    public void setSourceRange(String range) {
        setAngularText(0, "range-selector-input", range);
    }


    public void setTableHasHeader(boolean value) {
        setAngularCheckboxValue("My table has a header", value);
    }


    public void setRowReturnType(RowReturnTypeEnumeration rowReturnType) {
        setAngularComboboxValue(0, rowReturnType.getText());
    }


    public void setRowNumber(int rowNumber) {
        setAngularText(0, "ui-spinner-input", String.valueOf(rowNumber));
    }



}
