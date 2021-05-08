package googlesheets.model.text.extract.enums;

public enum CharacterTypeEnumeration {
    FIRST,
    LAST;

    public String getText() {
        switch (this) {
            case FIRST:
                return "The first";
            case LAST:
                return "The last";
            default:
                throw new IllegalStateException("Unknown character type: " + this);
        }
    }
}
