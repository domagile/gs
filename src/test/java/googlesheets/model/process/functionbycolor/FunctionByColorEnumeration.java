package googlesheets.model.process.functionbycolor;

public enum FunctionByColorEnumeration {
    SUM,
    COUNT,
    COUNTA,
    COUNTBLANK,
    AVERAGE,
    AVERAGEA,
    MIN,
    MAX,
    PRODUCT,
    MODE,
    STDEV,
    VAR,
    MEDIAN;


    public String getText() {
        switch (this) {
            case COUNT:
                return "COUNT (numbers)";
            case COUNTA:
                return "COUNTA (text)";
            default:
                return toString();
        }
    }
}
