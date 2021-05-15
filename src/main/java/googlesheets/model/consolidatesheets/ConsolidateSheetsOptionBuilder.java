package googlesheets.model.consolidatesheets;

import googlesheets.model.generic.ResultLocation;
import googlesheets.model.generic.sheetselection.SheetSelection;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsolidateSheetsOptionBuilder {
    private List<SheetSelection> sheets = new ArrayList<>();
    private List<SpreadsheetSelection> spreadsheetSelections = new ArrayList<>();
    private List<String> driveSheets = new ArrayList<>();

    private ConsolidationFunctionEnumeration consolidationFunction = ConsolidationFunctionEnumeration.SUM;
    private ConsolidationTypeEnumeration consolidationType = ConsolidationTypeEnumeration.BY_LABEL;
    private boolean useHeaderLabel;
    private boolean useLeftColumnLabel;

    private boolean useFormula;

    private ResultLocation resultLocation = ResultLocation.NEW_SHEET;
    private String customLocationValue;


    public ConsolidateSheetsOptionBuilder consolidationFunction(ConsolidationFunctionEnumeration consolidationFunction)
    {
        this.consolidationFunction = consolidationFunction;
        return this;
    }


    public ConsolidateSheetsOptionBuilder consolidationType(ConsolidationTypeEnumeration consolidationType)
    {
        this.consolidationType = consolidationType;
        return this;
    }


    public ConsolidateSheetsOptionBuilder useHeaderLabel(boolean useHeaderLabel)
    {
        this.useHeaderLabel = useHeaderLabel;
        return this;
    }


    public ConsolidateSheetsOptionBuilder useLeftColumnLabel(boolean useLeftColumnLabel)
    {
        this.useLeftColumnLabel = useLeftColumnLabel;
        return this;
    }


    public ConsolidateSheetsOptionBuilder useFormula(boolean useFormula)
    {
        this.useFormula = useFormula;
        return this;
    }


    public ConsolidateSheetsOptionBuilder resultLocation(ResultLocation resultLocation)
    {
        this.resultLocation = resultLocation;
        return this;
    }


    public ConsolidateSheetsOptionBuilder customLocationValue(String locationValue)
    {
        this.customLocationValue = locationValue;
        return this;
    }

    public ConsolidateSheetsOptionBuilder consolidatedSheet(int index)
    {
        sheets.add(new SheetSelection(index, null));
        return this;
    }


    public ConsolidateSheetsOptionBuilder consolidatedSheets(int... indexes)
    {
        Arrays.stream(indexes).forEach(index -> sheets.add(new SheetSelection(index, null)));
        return this;
    }


    public ConsolidateSheetsOptionBuilder consolidatedSheets(SheetSelection... sheetSelections)
    {
        this.sheets = Arrays.asList(sheetSelections);
        return this;
    }


    public ConsolidateSheetsOptionBuilder consolidatedSpreadsheets(SpreadsheetSelection... spreadsheetSelections) {
        this.spreadsheetSelections = Arrays.asList(spreadsheetSelections);
        return this;
    }


    public ConsolidateSheetsOptionBuilder driveSheets(String... sheets)
    {
        driveSheets = Arrays.asList(sheets);
        return this;
    }


    public ConsolidateSheetsOptions build()
    {
        ConsolidateSheetsOptions options = new ConsolidateSheetsOptions();
        options.setSelectedSheets(sheets);
        options.setSelectedSpreadsheets(spreadsheetSelections);
        options.setDriveSheets(driveSheets);
        options.setUseFormula(useFormula);
        options.setResultLocation(resultLocation);
        options.setCustomLocationValue(customLocationValue);
        options.setConsolidationFunction(consolidationFunction);
        options.setConsolidationType(consolidationType);
        options.setUseHeaderLabel(useHeaderLabel);
        options.setUseLeftColumnLabel(useLeftColumnLabel);
        return options;
    }
}
