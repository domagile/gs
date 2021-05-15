package googlesheets.model.text.split;

public enum SplitTypeEnumeration {
    BY_CHARACTER,
    BY_POSITION;


    public String getText()
    {
        switch (this) {
            case BY_CHARACTER:
                return "Split by character (text to columns)";
            case BY_POSITION:
                return "Split by position";
            default:
                throw new IllegalStateException("Unknown type: " + this);
        }
    }
}
