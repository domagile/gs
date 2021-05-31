package googlesheets.model.text.extract.enums;

public enum AllOccurrencesPlacementEnumeration {
    SEPARATE_CELLS,
    ONE_CELL;


    public String getText() {
        switch (this) {
            case SEPARATE_CELLS:
                return "Separate cells";
            case ONE_CELL:
                return "One cell";
            default:
                throw new IllegalStateException("Unknown placement: " + this);
        }
    }
}
