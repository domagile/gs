package googlesheets.model.consolidatesheets;

import googlesheets.model.generic.ResultLocation;
import googlesheets.model.generic.ResultLocationProvider;
import googlesheets.model.generic.sheetselection.SheetSelection;
import googlesheets.model.generic.sheetselection.SheetSelectionProvider;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;

import java.util.ArrayList;
import java.util.List;

public class ConsolidateSheetsOptions implements SheetSelectionProvider, ResultLocationProvider {
    private List<SheetSelection> sheets = new ArrayList<>();
    private List<String> driveSheets = new ArrayList<>();
    private List<SpreadsheetSelection> spreadsheetSelections = new ArrayList<>();

    private ConsolidationFunctionEnumeration consolidationFunction = ConsolidationFunctionEnumeration.SUM;
    private ConsolidationTypeEnumeration consolidationType = ConsolidationTypeEnumeration.BY_LABEL;
    private boolean useHeaderLabel;
    private boolean useLeftColumnLabel;

    private boolean useFormula;

    private ResultLocation resultLocation = ResultLocation.NEW_SHEET;
    private String customLocationValue;


    public boolean isUseFormula() {
        return useFormula;
    }

    public void setUseFormula(boolean useFormula) {
        this.useFormula = useFormula;
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
        return spreadsheetSelections;
    }

    public void setSelectedSpreadsheets(List<SpreadsheetSelection> spreadsheetSelections) {
        this.spreadsheetSelections = spreadsheetSelections;
    }

    public List<String> getDriveSheets() {
        return driveSheets;
    }

    public void setDriveSheets(List<String> driveSheets) {
        this.driveSheets = driveSheets;
    }

    public ConsolidationFunctionEnumeration getConsolidationFunction() {
        return consolidationFunction;
    }

    public void setConsolidationFunction(ConsolidationFunctionEnumeration consolidationFunction) {
        this.consolidationFunction = consolidationFunction;
    }

    public ConsolidationTypeEnumeration getConsolidationType() {
        return consolidationType;
    }

    public void setConsolidationType(ConsolidationTypeEnumeration consolidationType) {
        this.consolidationType = consolidationType;
    }

    public boolean isUseHeaderLabel() {
        return useHeaderLabel;
    }

    public void setUseHeaderLabel(boolean useHeaderLabel) {
        this.useHeaderLabel = useHeaderLabel;
    }

    public boolean isUseLeftColumnLabel() {
        return useLeftColumnLabel;
    }

    public void setUseLeftColumnLabel(boolean useLeftColumnLabel) {
        this.useLeftColumnLabel = useLeftColumnLabel;
    }

    @Override
    public boolean isNewSpreadsheet() {
        return resultLocation == ResultLocation.NEW_SPREADSHEET;
    }
}
