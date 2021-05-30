package googlesheets.model.text.modify;

public enum ModificationTypeEnumeration {
    CHANGE_CASE,
    REPLACE_SYMBOLS,
    POLISH_TEXT;


    public String getText() {
        switch (this) {
            case CHANGE_CASE:
                return "Change case";
            case REPLACE_SYMBOLS:
                return "Replace symbols";
            case POLISH_TEXT:
                return "Polish text";
            default:
                throw new IllegalStateException("Unknown type: " + this);
        }
    }
}
