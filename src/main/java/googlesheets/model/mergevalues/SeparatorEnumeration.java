package googlesheets.model.mergevalues;

public enum SeparatorEnumeration {
    SEMICOLON,
    COMMA,
    SPACE,
    LINE_BREAK;


    public String getText()
    {
        switch (this) {
            case SEMICOLON:
                return "[Semicolon]";
            case COMMA:
                return "[Comma]";
            case SPACE:
                return "[Space]";
            case LINE_BREAK:
                return "[Line break]";
            default:
                throw new IllegalStateException("Unknown separator " + this);
        }
    }
}
