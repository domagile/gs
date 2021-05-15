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
        setText("mergeCellsSeparateValues", separator);
    }


    public void setResultLocation(MergeValuesResultLocationEnumeration resultLocation) {
        selectAdxComboboxValue("mergeCellsResultPlaces-cs", resultLocation.getText());
    }


    public void setInsertNewColumn(boolean value) {
        setCheckboxValueByLabelClick("mergeCellsOptionPlaceOutside", value);
    }


    public void setClearContentsOfCells(boolean value) {
        setCheckboxValueByLabelClick("mergeCellsOptionClearContentLabel", value);
    }


    public void setMergeCellsInEachRow(boolean value) {
        setCheckboxValueByLabelClick("mergeCellsOptionMergeAll", value);
    }


    public void setSkipEmptyCells(boolean value) {
        setCheckboxValueByLabelClick("mergeCellsOptionSkipEmpty", value);
    }


    public void setWrapText(boolean value) {
        setCheckboxValueByLabelClick("mergeCellsOptionWrapText", value);
    }


    public void clickMerge()
    {
        clickElement("mergeCellsActionButton");
    }
}
