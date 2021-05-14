package googlesheets.model.process.functionbycolor;

public enum CalculationModeEnumeration {
    ENTIRE_RANGE,
    EACH_COLUMN,
    EACH_ROW;


    public String getText() {
        switch (this) {
            case ENTIRE_RANGE:
                return "entire range";
            case EACH_COLUMN:
                return "each column";
            case EACH_ROW:
                return "each row";
            default:
                throw new IllegalStateException("Unknown mode: " + this);
        }
    }
}
