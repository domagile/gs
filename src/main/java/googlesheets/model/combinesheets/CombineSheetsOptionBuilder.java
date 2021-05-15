package googlesheets.model.combinesheets;

import googlesheets.model.generic.ResultLocation;
import googlesheets.model.generic.sheetselection.SheetSelection;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineSheetsOptionBuilder {
    private List<SheetSelection> sheets = new ArrayList<>();
    private List<SpreadsheetSelection> spreadsheetSelections = new ArrayList<>();
    private List<String> driveSheets = new ArrayList<>();

    private boolean considerTableHeaders;
    private boolean useFormula;
    private boolean preserveFormatting;
    private boolean separateByBlankRow;

    private ResultLocation resultLocation;
    private String customLocationValue;


    public CombineSheetsOptionBuilder considerTableHeaders(boolean considerTableHeaders)
    {
        this.considerTableHeaders = considerTableHeaders;
        return this;
    }


    public CombineSheetsOptionBuilder useFormula(boolean useFormula)
    {
        this.useFormula = useFormula;
        return this;
    }


    public CombineSheetsOptionBuilder preserveFormatting(boolean preserveFormatting)
    {
        this.preserveFormatting = preserveFormatting;
        return this;
    }


    public CombineSheetsOptionBuilder separateByBlankRow(boolean separateByBlankRow)
    {
        this.separateByBlankRow = separateByBlankRow;
        return this;
    }


    public CombineSheetsOptionBuilder resultLocation(ResultLocation resultLocation)
    {
        this.resultLocation = resultLocation;
        return this;
    }


    public CombineSheetsOptionBuilder customLocationValue(String locationValue)
    {
        this.customLocationValue = locationValue;
        return this;
    }

    public CombineSheetsOptionBuilder combinedSheet(int index)
    {
        sheets.add(new SheetSelection(index, null));
        return this;
    }


    public CombineSheetsOptionBuilder combinedSheets(int... indexes)
    {
        Arrays.stream(indexes).forEach(index -> sheets.add(new SheetSelection(index, null)));
        return this;
    }


    public CombineSheetsOptionBuilder combinedSheets(SheetSelection... sheetSelections)
    {
        this.sheets = Arrays.asList(sheetSelections);
        return this;
    }


    public CombineSheetsOptionBuilder combinedSpreadsheets(SpreadsheetSelection... spreadsheetSelections) {
        this.spreadsheetSelections = Arrays.asList(spreadsheetSelections);
        return this;
    }


    public CombineSheetsOptionBuilder driveSheets(String... sheets)
    {
        driveSheets = Arrays.asList(sheets);
        return this;
    }


    public CombineSheetsOptions build()
    {
        CombineSheetsOptions options = new CombineSheetsOptions();
        options.setSelectedSheets(sheets);
        options.setSelectedSpreadsheets(spreadsheetSelections);
        options.setDriveSheets(driveSheets);
        options.setConsiderTableHeaders(considerTableHeaders);
        options.setUseFormula(useFormula);
        options.setPreserveFormatting(preserveFormatting);
        options.setSeparateByBlankRow(separateByBlankRow);
        options.setResultLocation(resultLocation);
        options.setCustomLocationValue(customLocationValue);
        return options;
    }
}
