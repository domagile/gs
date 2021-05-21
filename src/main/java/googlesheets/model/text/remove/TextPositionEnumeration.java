package googlesheets.model.text.remove;

public enum TextPositionEnumeration {
    BEFORE,
    AFTER;


    public String getText() {
        switch (this) {
            case BEFORE:
                return "Before";
            case AFTER:
                return "After";
            default:
                throw new IllegalStateException("Unknown text position: " + this);
        }
    }
}
