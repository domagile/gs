package googlesheets.model.text.extract.enums;

public enum ThousandsSeparatorEnumeration {
    COMMA,
    POINT,
    THIN_SPACE,
    SPACE,
    NO_BREAK_SPACE,
    UNDERSCORE,
    APOSTROPHE;


    public String getText() {
        switch (this) {
            case COMMA:
                return ",";
            case POINT:
                return ".";
            case THIN_SPACE:
                return "[Thin-space]";
            case SPACE:
                return "[Space]";
            case NO_BREAK_SPACE:
                return "[No-break space]";
            case UNDERSCORE:
                return "_";
            case APOSTROPHE:
                return "'";
            default:
                throw new IllegalStateException("Unknown separator: " + this);
        }
    }
}
