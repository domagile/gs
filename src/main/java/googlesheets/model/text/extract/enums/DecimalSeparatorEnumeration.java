package googlesheets.model.text.extract.enums;

public enum DecimalSeparatorEnumeration {
    POINT,
    COMMA;


    public String getText() {
        switch (this) {
            case POINT:
                return ".";
            case COMMA:
                return ",";
            default:
                throw new IllegalStateException("Unknown separator: " + this);
        }
    }
}
