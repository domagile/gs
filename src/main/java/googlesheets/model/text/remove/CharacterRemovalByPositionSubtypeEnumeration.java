package googlesheets.model.text.remove;

public enum CharacterRemovalByPositionSubtypeEnumeration {
    CHARACTERS_BY_POSITION,
    FIRST_LAST_CHARACTERS,
    CHARACTERS_BEFORE_AFTER_TEXT;

    public String getText() {
        switch (this) {
            case CHARACTERS_BY_POSITION:
                return "Remove characters by position:";
            case FIRST_LAST_CHARACTERS:
                return "Remove the first/last characters:";
            case CHARACTERS_BEFORE_AFTER_TEXT:
                return "Remove characters before/after text:";
            default:
                throw new IllegalStateException("Unknown subtype: " + this);
        }
    }
}
