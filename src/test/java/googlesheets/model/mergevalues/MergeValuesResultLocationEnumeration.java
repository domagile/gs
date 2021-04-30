package googlesheets.model.mergevalues;

public enum MergeValuesResultLocationEnumeration {
    LEFT_CELL,
    RIGHT_CELL,
    TOP_CELL,
    BOTTOM_CELL,
    TOP_LEFT_CORNER,
    TOP_RIGHT_CORNER,
    BOTTOM_LEFT_CORNER,
    BOTTOM_RIGHT_CORNER;


    public String getText()
    {
        switch (this) {
            case LEFT_CELL:
                return "left cell";
            case RIGHT_CELL:
                return "right cell";
            case TOP_CELL:
                return "top cell";
            case BOTTOM_CELL:
                return "bottom cell";
            case TOP_LEFT_CORNER:
                return "top-left corner";
            case TOP_RIGHT_CORNER:
                return "top-right corner";
            case BOTTOM_LEFT_CORNER:
                return "bottom-left corner";
            case BOTTOM_RIGHT_CORNER:
                return "bottom-right corner";
            default:
                throw new IllegalStateException("Unknown result location " + this);
        }
    }
}
