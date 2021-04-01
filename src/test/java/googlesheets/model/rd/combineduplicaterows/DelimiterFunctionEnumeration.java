package googlesheets.model.rd.combineduplicaterows;

public enum DelimiterFunctionEnumeration {
    LINE_BREAK,
    SPACE,
    COMMA,
    SEMICOLON,

    SUM,
    COUNT,
    COUNTA,
    AVERAGE,
    AVERAGEA,
    MIN,
    MAX,
    PRODUCT,
    MODE,
    STDEV,
    STDEVP,
    VAR,
    VARP,
    MEDIAN;


    public boolean isDelimiter()
    {
        switch (this) {
            case LINE_BREAK:
            case SPACE:
            case COMMA:
            case SEMICOLON:
                return true;
            default:
                return false;
        }
    }


    public String getText() {
        switch (this) {
            case LINE_BREAK:
                return "[Line break]";
            case SPACE:
                return "[Space]";
            case COMMA:
                return "[Comma]";
            case SEMICOLON:
                return "[Semicolon]";
            case SUM:
                return "[SUM]";
            case COUNT:
                return "[COUNT]";
            case COUNTA:
                return "[COUNTA]";
            case AVERAGE:
                return "[AVERAGE]";
            case AVERAGEA:
                return "[AVERAGEA]";
            case MIN:
                return "[MIN]";
            case MAX:
                return "[MAX]";
            case PRODUCT:
                return "[PRODUCT]";
            case MODE:
                return "[MODE]";
            case STDEV:
                return "[STDEV]";
            case STDEVP:
                return "[STDEVP]";
            case VAR:
                return "[VAR]";
            case VARP:
                return "[VARP]";
            case MEDIAN:
                return "[MEDIAN]";
            default:
                throw new IllegalStateException("Unknown action" + this.toString());
        }
    }
}