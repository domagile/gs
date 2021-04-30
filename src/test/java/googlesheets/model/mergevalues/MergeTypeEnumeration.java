package googlesheets.model.mergevalues;

public enum MergeTypeEnumeration {
    SELECTED_ROW,
    SELECTED_COLUMN,
    ONE_CELL;


    public String getText()
    {
        switch (this) {
            case SELECTED_ROW:
                return "in each selected row";
            case SELECTED_COLUMN:
                return "in each selected column";
            case ONE_CELL:
                return "into one cell";
            default:
                throw new IllegalStateException("Unknown merge type: " + this);
        }
    }
}
