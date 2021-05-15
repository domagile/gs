package googlesheets.model.combinesheets;

import googlesheets.model.generic.ResultLocation;
import googlesheets.model.generic.ResultLocationProvider;
import googlesheets.model.generic.sheetselection.SheetSelection;
import googlesheets.model.generic.sheetselection.SheetSelectionProvider;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;

import java.util.ArrayList;
import java.util.List;

public class CombineSheetsOptions implements SheetSelectionProvider, ResultLocationProvider {
    private List<SheetSelection> sheets = new ArrayList<>();
    private List<String> driveSheets = new ArrayList<>();
    private List<SpreadsheetSelection> selectedSpreadsheets = new ArrayList<>();

    private boolean considerTableHeaders;
    private boolean useFormula;
    private boolean preserveFormatting;
    private boolean separateByBlankRow;

    private ResultLocation resultLocation = ResultLocation.NEW_SHEET;
    private String customLocationValue;


    public boolean isConsiderTableHeaders() {
        return considerTableHeaders;
    }

    public void setConsiderTableHeaders(boolean considerTableHeaders) {
        this.considerTableHeaders = considerTableHeaders;
    }

    public boolean isUseFormula() {
        return useFormula;
    }

    public void setUseFormula(boolean useFormula) {
        this.useFormula = useFormula;
    }

    public boolean isPreserveFormatting() {
        return preserveFormatting;
    }

    public void setPreserveFormatting(boolean preserveFormatting) {
        this.preserveFormatting = preserveFormatting;
    }

    public boolean isSeparateByBlankRow() {
        return separateByBlankRow;
    }

    public void setSeparateByBlankRow(boolean separateByBlankRow) {
        this.separateByBlankRow = separateByBlankRow;
    }

    public ResultLocation getResultLocation() {
        return resultLocation;
    }

    public void setResultLocation(ResultLocation resultLocation) {
        this.resultLocation = resultLocation;
    }

    public String getCustomLocationValue() {
        return customLocationValue;
    }

    public void setCustomLocationValue(String locationValue) {
        this.customLocationValue = locationValue;
    }

    public List<SheetSelection> getSelectedSheets()
    {
        return sheets;
    }

    public void addSheet(int index) {
        sheets.add(new SheetSelection(index, null));
    }

    public void setSelectedSheets(List<SheetSelection> sheets)
    {
        this.sheets = sheets;
    }

    public List<SpreadsheetSelection> getSelectedSpreadsheets() {
        return selectedSpreadsheets;
    }

    public void setSelectedSpreadsheets(List<SpreadsheetSelection> selectedSpreadsheets) {
        this.selectedSpreadsheets = selectedSpreadsheets;
    }

    public List<String> getDriveSheets() {
        return driveSheets;
    }

    public void setDriveSheets(List<String> driveSheets) {
        this.driveSheets = driveSheets;
    }


    @Override
    public boolean isNewSpreadsheet() {
        return resultLocation == ResultLocation.NEW_SPREADSHEET;
    }
}
