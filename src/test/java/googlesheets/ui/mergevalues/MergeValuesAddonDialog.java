package googlesheets.ui.mergevalues;

import googlesheets.model.mergevalues.MergeTypeEnumeration;
import googlesheets.model.mergevalues.MergeValuesResultLocationEnumeration;
import googlesheets.model.mergevalues.SeparatorEnumeration;
import org.openqa.selenium.NoSuchElementException;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public class MergeValuesAddonDialog {
    public void setMergeType(MergeTypeEnumeration mergeType) {
        selectAdxComboboxValue("mergeCellsChooseMerge-cs", mergeType.getText());
    }


    public void setPredefinedSeparator(SeparatorEnumeration separator) {
        try {
            selectAdxComboboxValue("mergeCellsSeparateValues-cs", separator.getText());
        }
        catch (NoSuchElementException e) {
            setCustomSeparator(separator.getText());
        }
    }


    public void setCustomSeparator(String separator) {
        setText(separator, "mergeCellsSeparateValues");
    }


    public void setResultLocation(MergeValuesResultLocationEnumeration resultLocation) {
        selectAdxComboboxValue("mergeCellsResultPlaces-cs", resultLocation.getText());
    }


    public void setInsertNewColumn(boolean value) {
        setCheckboxValueByLabelClick(value, "mergeCellsOptionPlaceOutside");
    }


    public void setClearContentsOfCells(boolean value) {
        setCheckboxValueByLabelClick(value, "mergeCellsOptionClearContentLabel");
    }


    public void setMergeCellsInEachRow(boolean value) {
        setCheckboxValueByLabelClick(value, "mergeCellsOptionMergeAll");
    }


    public void setSkipEmptyCells(boolean value) {
        setCheckboxValueByLabelClick(value, "mergeCellsOptionSkipEmpty");
    }


    public void setWrapText(boolean value) {
        setCheckboxValueByLabelClick(value, "mergeCellsOptionWrapText");
    }


    public void clickMerge()
    {
        clickElement("mergeCellsActionButton");
    }
}
