package googlesheets.model.text.extract.enums;

public enum DataTypeEnumeration {
    HYPERLINK,
    URL,
    EMAIL;

    public String getText() {
        switch (this) {
            case HYPERLINK:
                return "Hyperlinks (text + link)";
            case URL:
                return "URLs (link)";
            case EMAIL:
                return "Email addresses";
            default:
                throw new IllegalStateException("Unknown data type: " + this);
        }
    }
}
