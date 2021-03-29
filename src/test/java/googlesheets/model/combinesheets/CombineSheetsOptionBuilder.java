package googlesheets.model.combinesheets;

import googlesheets.model.generic.ResultLocation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineSheetsOptionBuilder {
    private List<SheetSelection> sheets = new ArrayList<>();

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


    public CombineSheetsOptions build()
    {
        CombineSheetsOptions options = new CombineSheetsOptions();
        options.setCombinedSheets(sheets);
        options.setConsiderTableHeaders(considerTableHeaders);
        options.setUseFormula(useFormula);
        options.setPreserveFormatting(preserveFormatting);
        options.setSeparateByBlankRow(separateByBlankRow);
        options.setResultLocation(resultLocation);
        options.setCustomLocationValue(customLocationValue);
        return options;
    }
}
