package googlesheets.model.mergesheets;

public enum ColumnDisplayEnumeration {
    ALL_COLUMNS,
    ADD_TO_END_ONLY,
    UPDATE_VALUES_IN_ONLY,
    MATCHING_COLUMNS;

    public String getText() {
        switch (this) {
            case ALL_COLUMNS:
                return "all columns";
            case ADD_TO_END_ONLY:
                return "add to the end only";
            case UPDATE_VALUES_IN_ONLY:
                return "update values in only";
            case MATCHING_COLUMNS:
                return "matching columns";
            default:
                throw new IllegalStateException("Unknown value");
        }
    }
}
