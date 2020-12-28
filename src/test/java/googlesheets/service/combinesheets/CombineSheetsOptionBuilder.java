package googlesheets.service.combinesheets;

public class CombineSheetsOptionBuilder {
    private boolean considerTableHeaders;
    private boolean useFormula;
    private boolean preserveFormatting;
    private boolean separateByBlankRow;

    private ResultLocation resultLocation;
    private String locationValue;


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


    public CombineSheetsOptionBuilder locationValue(String locationValue)
    {
        this.locationValue = locationValue;
        return this;
    }


    public CombineSheetsOptions build()
    {
        CombineSheetsOptions options = new CombineSheetsOptions();
        options.setConsiderTableHeaders(considerTableHeaders);
        options.setUseFormula(useFormula);
        options.setPreserveFormatting(preserveFormatting);
        options.setSeparateByBlankRow(separateByBlankRow);
        options.setResultLocation(resultLocation);
        options.setLocationValue(locationValue);
        return options;
    }
}
