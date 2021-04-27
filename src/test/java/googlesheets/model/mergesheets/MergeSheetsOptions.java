package googlesheets.model.mergesheets;

import googlesheets.model.generic.ResultLocationProvider;
import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;

import java.util.ArrayList;
import java.util.List;

public class MergeSheetsOptions implements ResultLocationProvider {
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


    public String getMainSheet() {
        return mainSheet;
    }

    public void setMainSheet(String mainSheet) {
        this.mainSheet = mainSheet;
    }

    public String getMainTableRange() {
        return mainTableRange;
    }

    public void setMainTableRange(String mainTableRange) {
        this.mainTableRange = mainTableRange;
    }

    public boolean isCreateBackupCopy() {
        return createBackupCopy;
    }

    public void setCreateBackupCopy(boolean createBackupCopy) {
        this.createBackupCopy = createBackupCopy;
    }

    public String getLookupSpreadsheet() {
        return lookupSpreadsheet;
    }

    public void setLookupSpreadsheet(String lookupSpreadsheet) {
        this.lookupSpreadsheet = lookupSpreadsheet;
    }

    public String getLookupSheet() {
        return lookupSheet;
    }

    public void setLookupSheet(String lookupSheet) {
        this.lookupSheet = lookupSheet;
    }

    public String getLookupTableRange() {
        return lookupTableRange;
    }

    public void setLookupTableRange(String lookupTableRange) {
        this.lookupTableRange = lookupTableRange;
    }

    public boolean isMainTableHasHeaders() {
        return mainTableHasHeaders;
    }

    public void setMainTableHasHeaders(boolean mainTableHasHeaders) {
        this.mainTableHasHeaders = mainTableHasHeaders;
    }

    public boolean isLookupTableHasHeaders() {
        return lookupTableHasHeaders;
    }

    public void setLookupTableHasHeaders(boolean lookupTableHasHeaders) {
        this.lookupTableHasHeaders = lookupTableHasHeaders;
    }

    public boolean isSkipEmptyCells() {
        return skipEmptyCells;
    }

    public void setSkipEmptyCells(boolean skipEmptyCells) {
        this.skipEmptyCells = skipEmptyCells;
    }

    public boolean isMatchCase() {
        return matchCase;
    }

    public void setMatchCase(boolean matchCase) {
        this.matchCase = matchCase;
    }

    public List<PairSelection<Integer, String>> getMatchingColumns() {
        return matchingColumns;
    }

    public void setMatchingColumns(List<PairSelection<Integer, String>> matchingColumns) {
        this.matchingColumns = matchingColumns;
    }

    public ColumnDisplayEnumeration getColumnDisplay() {
        return columnDisplay;
    }

    public void setColumnDisplay(ColumnDisplayEnumeration columnDisplay) {
        this.columnDisplay = columnDisplay;
    }

    public List<TripleSelection<Integer, MergeSheetsActionEnumeration, String>> getUpdatedColumns() {
        return updatedColumns;
    }

    public void setUpdatedColumns(List<TripleSelection<Integer, MergeSheetsActionEnumeration, String>> updatedColumns) {
        this.updatedColumns = updatedColumns;
    }

    public boolean isAddNonMatchingRows() {
        return addNonMatchingRows;
    }

    public void setAddNonMatchingRows(boolean addNonMatchingRows) {
        this.addNonMatchingRows = addNonMatchingRows;
    }

    public boolean isAddStatusColumn() {
        return addStatusColumn;
    }

    public void setAddStatusColumn(boolean addStatusColumn) {
        this.addStatusColumn = addStatusColumn;
    }

    public boolean isUpdateOnlyEmptyNewCells() {
        return updateOnlyEmptyNewCells;
    }

    public void setUpdateOnlyEmptyNewCells(boolean updateOnlyEmptyNewCells) {
        this.updateOnlyEmptyNewCells = updateOnlyEmptyNewCells;
    }

    public boolean isUpdateOnlyIfCellsFromLookupContainData() {
        return updateOnlyIfCellsFromLookupContainData;
    }

    public void setUpdateOnlyIfCellsFromLookupContainData(boolean updateOnlyIfCellsFromLookupContainData) {
        this.updateOnlyIfCellsFromLookupContainData = updateOnlyIfCellsFromLookupContainData;
    }

    public boolean isClearBackground() {
        return clearBackground;
    }

    public void setClearBackground(boolean clearBackground) {
        this.clearBackground = clearBackground;
    }

    public boolean isColorUpdatedCells() {
        return colorUpdatedCells;
    }

    public void setColorUpdatedCells(boolean colorUpdatedCells) {
        this.colorUpdatedCells = colorUpdatedCells;
    }

    public MergeSheetsResultLocationEnumeration getResultLocation() {
        return resultLocation;
    }

    public void setResultLocation(MergeSheetsResultLocationEnumeration resultLocation) {
        this.resultLocation = resultLocation;
    }


    @Override
    public boolean isNewSpreadsheet() {
        return resultLocation == MergeSheetsResultLocationEnumeration.NEW_SPREADSHEET;
    }
}
