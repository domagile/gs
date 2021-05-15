package googlesheets.model.mergesheets;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeSheetsOptionBuilder {
    private String mainSheet;
    private String mainTableRange;
    private boolean createBackupCopy;
    private String lookupSpreadsheet;
    private String lookupSheet;
    private String lookupTableRange;
    private boolean mainTableHasHeaders;
    private boolean lookupTableHasHeaders;
    private boolean skipEmptyCells;
    private boolean matchCase;
    private List<PairSelection<Integer, String>> matchingColumns = new ArrayList<>();
    private ColumnDisplayEnumeration columnDisplay = ColumnDisplayEnumeration.ALL_COLUMNS;
    private List<TripleSelection<Integer, MergeSheetsActionEnumeration, String>> updatedColumns = new ArrayList<>();

    private boolean addNonMatchingRows;
    private boolean addStatusColumn;
    private boolean updateOnlyEmptyNewCells;
    private boolean updateOnlyIfCellsFromLookupContainData;
    private boolean clearBackground;
    private boolean colorUpdatedCells;
    private MergeSheetsResultLocationEnumeration resultLocation = MergeSheetsResultLocationEnumeration.UPDATE_MAIN_TABLE;


    public MergeSheetsOptionBuilder mainSheet(String mainSheet)
    {
        this.mainSheet = mainSheet;
        return this;
    }

    public MergeSheetsOptionBuilder mainTableRange(String mainTableRange)
    {
        this.mainTableRange = mainTableRange;
        return this;
    }

    public MergeSheetsOptionBuilder createBackupCopy(boolean createBackupCopy)
    {
        this.createBackupCopy = createBackupCopy;
        return this;
    }

    public MergeSheetsOptionBuilder lookupSpreadsheet(String lookupSpreadsheet)
    {
        this.lookupSpreadsheet = lookupSpreadsheet;
        return this;
    }

    public MergeSheetsOptionBuilder lookupSheet(String lookupSheet)
    {
        this.lookupSheet = lookupSheet;
        return this;
    }

    public MergeSheetsOptionBuilder lookupTableRange(String lookupTableRange)
    {
        this.lookupTableRange = lookupTableRange;
        return this;
    }

    public MergeSheetsOptionBuilder mainTableHasHeaders(boolean mainTableHasHeaders)
    {
        this.mainTableHasHeaders = mainTableHasHeaders;
        return this;
    }

    public MergeSheetsOptionBuilder lookupTableHasHeaders(boolean lookupTableHasHeaders)
    {
        this.lookupTableHasHeaders = lookupTableHasHeaders;
        return this;
    }

    public MergeSheetsOptionBuilder skipEmptyCells(boolean skipEmptyCells)
    {
        this.skipEmptyCells = skipEmptyCells;
        return this;
    }

    public MergeSheetsOptionBuilder matchCase(boolean matchCase)
    {
        this.matchCase = matchCase;
        return this;
    }

    public MergeSheetsOptionBuilder matchingColumns(PairSelection<Integer, String>... matchingColumns)
    {
        this.matchingColumns = Arrays.asList(matchingColumns);
        return this;
    }

    public MergeSheetsOptionBuilder columnDisplay(ColumnDisplayEnumeration columnDisplay)
    {
        this.columnDisplay = columnDisplay;
        return this;
    }

    public MergeSheetsOptionBuilder updatedColumns(TripleSelection<Integer, MergeSheetsActionEnumeration, String>... updatedColumns)
    {
        this.updatedColumns = Arrays.asList(updatedColumns);
        return this;
    }

    public MergeSheetsOptionBuilder addNonMatchingRows(boolean addNonMatchingRows)
    {
        this.addNonMatchingRows = addNonMatchingRows;
        return this;
    }

    public MergeSheetsOptionBuilder addStatusColumn(boolean addStatusColumn)
    {
        this.addStatusColumn = addStatusColumn;
        return this;
    }

    public MergeSheetsOptionBuilder updateOnlyEmptyNewCells(boolean updateOnlyEmptyNewCells)
    {
        this.updateOnlyEmptyNewCells = updateOnlyEmptyNewCells;
        return this;
    }

    public MergeSheetsOptionBuilder updateOnlyIfCellsFromLookupContainData(boolean updateOnlyIfCellsFromLookupContainData)
    {
        this.updateOnlyIfCellsFromLookupContainData = updateOnlyIfCellsFromLookupContainData;
        return this;
    }

    public MergeSheetsOptionBuilder clearBackground(boolean clearBackground)
    {
        this.clearBackground = clearBackground;
        return this;
    }

    public MergeSheetsOptionBuilder colorUpdatedCells(boolean colorUpdatedCells)
    {
        this.colorUpdatedCells = colorUpdatedCells;
        return this;
    }

    public MergeSheetsOptionBuilder resultLocation(MergeSheetsResultLocationEnumeration resultLocation)
    {
        this.resultLocation = resultLocation;
        return this;
    }

    public MergeSheetsOptions build()
    {
        MergeSheetsOptions options = new MergeSheetsOptions();
        options.setMainSheet(mainSheet);
        options.setMainTableRange(mainTableRange);
        options.setCreateBackupCopy(createBackupCopy);
        options.setLookupSpreadsheet(lookupSpreadsheet);
        options.setLookupSheet(lookupSheet);
        options.setLookupTableRange(lookupTableRange);
        options.setMainTableHasHeaders(mainTableHasHeaders);
        options.setLookupTableHasHeaders(lookupTableHasHeaders);
        options.setSkipEmptyCells(skipEmptyCells);
        options.setMatchCase(matchCase);
        options.setMatchingColumns(matchingColumns);
        options.setColumnDisplay(columnDisplay);
        options.setUpdatedColumns(updatedColumns);
        options.setAddNonMatchingRows(addNonMatchingRows);
        options.setAddStatusColumn(addStatusColumn);
        options.setUpdateOnlyEmptyNewCells(updateOnlyEmptyNewCells);
        options.setUpdateOnlyIfCellsFromLookupContainData(updateOnlyIfCellsFromLookupContainData);
        options.setClearBackground(clearBackground);
        options.setColorUpdatedCells(colorUpdatedCells);
        options.setResultLocation(resultLocation);
        return options;
    }
}


