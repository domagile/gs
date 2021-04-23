package googlesheets.model.mergesheets;

public enum MergeSheetsActionEnumeration {
    ADD_TO_END,
    UPDATE_VALUES_IN;

    public String getText()
    {
        switch (this) {
            case ADD_TO_END:
                return "Add to the end";
            case UPDATE_VALUES_IN:
                return "Update values in";
            default:
                throw new IllegalStateException("Unknown value");
        }
    }
}
