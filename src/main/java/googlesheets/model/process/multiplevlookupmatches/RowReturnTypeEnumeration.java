package googlesheets.model.process.multiplevlookupmatches;

public enum RowReturnTypeEnumeration {
    ALL,
    FIRST;


    public String getText() {
        switch (this) {
            case ALL:
                return "All";
            case FIRST:
                return "First";
            default:
                throw new IllegalStateException("Unknown row return type: " + this);
        }
    }
}
