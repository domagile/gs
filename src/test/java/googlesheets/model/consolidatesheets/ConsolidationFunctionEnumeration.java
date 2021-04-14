package googlesheets.model.consolidatesheets;

public enum ConsolidationFunctionEnumeration {
    SUM,
    COUNT,
    COUNTA,
    AVERAGE,
    MAX,
    MIN,
    PRODUCT,
    STDEV,
    STDEVP,
    VAR,
    VARP;


    public String getText()
    {
        switch (this) {
            case COUNT:
                return "COUNT (numbers)";
            case COUNTA:
                return "COUNTA (text)";
            default:
                return name();
        }
    }
}
