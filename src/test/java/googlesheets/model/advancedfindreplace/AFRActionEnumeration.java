package googlesheets.model.advancedfindreplace;

public enum AFRActionEnumeration {
    EXPORT_ALL_FOUND_ENTRIES,
    EXPORT_ROWS_WITH_ALL_ENTRIES,
    DELETE_ROWS_WITH_ALL_ENTRIES,
    EXPORT_SELECTED_ENTRIES,
    EXPORT_ROWS_WITH_SELECTED_ENTRIES,
    DELETE_ROWS_WITH_SELECTED_ENTRIES;

    //todo: finish method
    public String getMenuText()
    {
        switch (this) {
            case EXPORT_ALL_FOUND_ENTRIES:
                return "Export all found entries";
            case EXPORT_ROWS_WITH_ALL_ENTRIES:
                return "Export rows with all found entries";
            case DELETE_ROWS_WITH_ALL_ENTRIES:
                return "Delete rows with all found entries";
            case EXPORT_SELECTED_ENTRIES:
                return "Export the selected entries";
            case EXPORT_ROWS_WITH_SELECTED_ENTRIES:
                return "Export rows with the selected entries";
            case DELETE_ROWS_WITH_SELECTED_ENTRIES:
                return "Delete rows with the selected entries";
            default:
                throw new IllegalStateException("Unknown action");
        }
    }
}


