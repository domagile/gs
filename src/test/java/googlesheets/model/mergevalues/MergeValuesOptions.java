package googlesheets.model.mergevalues;

public class MergeValuesOptions {
    private String range;
    private MergeTypeEnumeration mergeType = MergeTypeEnumeration.SELECTED_ROW;
    private SeparatorEnumeration predefinedSeparator;
    private String customSeparator;
    private MergeValuesResultLocationEnumeration resultLocation = MergeValuesResultLocationEnumeration.LEFT_CELL;

    private boolean insertNewColumn;
    private boolean clearContentsOfCells;
    private boolean mergeCells;
    private boolean skipEmptyCells;
    private boolean wrapText;

    public MergeTypeEnumeration getMergeType() {
        return mergeType;
    }

    public void setMergeType(MergeTypeEnumeration mergeType) {
        this.mergeType = mergeType;
    }

    public SeparatorEnumeration getPredefinedSeparator() {
        return predefinedSeparator;
    }

    public String getCustomSeparator() {
        return customSeparator;
    }

    public void setPredefinedSeparator(SeparatorEnumeration separator) {
        this.predefinedSeparator = separator;
    }

    public void setCustomSeparator(String separator) {
        this.customSeparator = separator;
    }

    public MergeValuesResultLocationEnumeration getResultLocation() {
        return resultLocation;
    }

    public void setResultLocation(MergeValuesResultLocationEnumeration resultLocation) {
        this.resultLocation = resultLocation;
    }

    public boolean isInsertNewColumn() {
        return insertNewColumn;
    }

    public void setInsertNewColumn(boolean insertNewColumn) {
        this.insertNewColumn = insertNewColumn;
    }

    public boolean isClearContentsOfCells() {
        return clearContentsOfCells;
    }

    public void setClearContentsOfCells(boolean clearContentsOfCells) {
        this.clearContentsOfCells = clearContentsOfCells;
    }

    public boolean isMergeCells() {
        return mergeCells;
    }

    public void setMergeCells(boolean mergeCells) {
        this.mergeCells = mergeCells;
    }

    public boolean isSkipEmptyCells() {
        return skipEmptyCells;
    }

    public void setSkipEmptyCells(boolean skipEmptyCells) {
        this.skipEmptyCells = skipEmptyCells;
    }

    public boolean isWrapText() {
        return wrapText;
    }

    public void setWrapText(boolean wrapText) {
        this.wrapText = wrapText;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
