package googlesheets.model.text.modify;

public enum CaseActionEnumeration {
    SENTENCE_CASE,
    CAPITALIZE_EACH_WORD,
    LOWER_CASE,
    UPPER_CASE,
    TOGGLE_TEXT;

    public String getText() {
        switch (this) {
            case SENTENCE_CASE:
                return "Sentence case.";
            case CAPITALIZE_EACH_WORD:
                return "Capitalize Each Word";
            case LOWER_CASE:
                return "lower case";
            case UPPER_CASE:
                return "UPPER CASE";
            case TOGGLE_TEXT:
                return "tOGGLE tEXT";
            default:
                throw new IllegalStateException("Unknown action: " + this);
        }
    }
}
