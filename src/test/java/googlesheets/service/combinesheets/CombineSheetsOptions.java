package googlesheets.service.combinesheets;

public class CombineSheetsOptions {
    private boolean considerTableHeaders;
    private boolean useFormula;
    private boolean preserveFormatting;
    private boolean separateByBlankRow;

    private ResultLocation resultLocation = ResultLocation.NEW_SHEET;
    private String locationValue;


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

    public String getLocationValue() {
        return locationValue;
    }

    public void setLocationValue(String locationValue) {
        this.locationValue = locationValue;
    }
}
