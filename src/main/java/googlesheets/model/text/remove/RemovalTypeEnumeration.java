package googlesheets.model.text.remove;

public enum RemovalTypeEnumeration {
    SUBSTRINGS_OR_CHARACTERS,
    SPACES_AND_DELIMITERS,
    CHARACTERS_BY_POSITION;

    public String getText() {
        switch (this) {
            case SUBSTRINGS_OR_CHARACTERS:
                return "Remove substrings or characters";
            case SPACES_AND_DELIMITERS:
                return "Remove spaces and delimiters";
            case CHARACTERS_BY_POSITION:
                return "Remove characters by position";
            default:
                throw new IllegalStateException("Unknown type " + this);
        }
    }
}
