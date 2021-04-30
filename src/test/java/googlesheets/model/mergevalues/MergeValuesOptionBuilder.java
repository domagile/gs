package googlesheets.model.mergevalues;

public class MergeValuesOptionBuilder {
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

    public MergeValuesOptionBuilder range(String range) {
        this.range = range;
        return this;
    }


    public MergeValuesOptionBuilder mergeType(MergeTypeEnumeration mergeType)
    {
        this.mergeType = mergeType;
        return this;
    }

    public MergeValuesOptionBuilder predefinedSeparator(SeparatorEnumeration separator)
    {
        this.predefinedSeparator = separator;
        return this;
    }

    public MergeValuesOptionBuilder customSeparator(String separator)
    {
        this.customSeparator = separator;
        return this;
    }

    public MergeValuesOptionBuilder resultLocation(MergeValuesResultLocationEnumeration resultLocation)
    {
        this.resultLocation = resultLocation;
        return this;
    }

    public MergeValuesOptionBuilder insertNewColumn(boolean insertNewColumn)
    {
        this.insertNewColumn = insertNewColumn;
        return this;
    }

    public MergeValuesOptionBuilder clearContentsOfCells(boolean clearContentsOfCells)
    {
        this.clearContentsOfCells = clearContentsOfCells;
        return this;
    }

    public MergeValuesOptionBuilder mergeCells(boolean mergeCells)
    {
        this.mergeCells = mergeCells;
        return this;
    }

    public MergeValuesOptionBuilder skipEmptyCells(boolean skipEmptyCells)
    {
        this.skipEmptyCells = skipEmptyCells;
        return this;
    }

    public MergeValuesOptionBuilder wrapText(boolean wrapText)
    {
        this.wrapText = wrapText;
        return this;
    }

    public MergeValuesOptions build()
    {
        MergeValuesOptions options = new MergeValuesOptions();
        options.setRange(range);
        options.setMergeType(mergeType);
        options.setPredefinedSeparator(predefinedSeparator);
        options.setCustomSeparator(customSeparator);
        options.setResultLocation(resultLocation);
        options.setInsertNewColumn(insertNewColumn);
        options.setClearContentsOfCells(clearContentsOfCells);
        options.setMergeCells(mergeCells);
        options.setSkipEmptyCells(skipEmptyCells);
        options.setWrapText(wrapText);
        return options;
    }
}
