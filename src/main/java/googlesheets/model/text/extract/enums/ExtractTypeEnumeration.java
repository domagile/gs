package googlesheets.model.text.extract.enums;

public enum ExtractTypeEnumeration {
    FIRST_LAST_CHARACTERS,
    BY_STRINGS,
    BY_POSITION,
    NUMBERS,
    LINKS,
    BY_MASK;


    public String getText() {
        switch (this) {
            case FIRST_LAST_CHARACTERS:
                return "Extract the first/last N characters";
            case BY_STRINGS:
                return "Extract by strings";
            case BY_POSITION:
                return "Extract by position";
            case NUMBERS:
                return "Extract numbers";
            case LINKS:
                return "Extract links";
            case BY_MASK:
                return "Extract by mask";
            default:
                throw new IllegalStateException("Unknown extract type: " + this);
        }
    }
}
