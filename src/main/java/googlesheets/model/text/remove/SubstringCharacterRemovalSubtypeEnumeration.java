package googlesheets.model.text.remove;

public enum SubstringCharacterRemovalSubtypeEnumeration {
    SUBSTRINGS,
    CHARACTERS;

    public String getText() {
        switch (this) {
            case SUBSTRINGS:
                return "Remove substrings individually:";
            case CHARACTERS:
                return "Remove entered characters individually:";
            default:
                throw new IllegalStateException("Unknown subtype: " + this);
        }
    }
}
