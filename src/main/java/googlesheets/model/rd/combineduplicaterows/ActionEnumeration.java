package googlesheets.model.rd.combineduplicaterows;

public enum ActionEnumeration {
    MERGE_VALUES,
    CALCULATE_NUMBERS;

    public String getText() {
        switch (this) {
            case MERGE_VALUES:
                return "Merge values";
            case CALCULATE_NUMBERS:
                return "Calculate numbers";
            default:
                throw new IllegalStateException("Unknown action" + this.toString());
        }
    }
}
