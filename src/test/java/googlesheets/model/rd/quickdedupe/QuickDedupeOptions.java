package googlesheets.model.rd.quickdedupe;

import java.util.ArrayList;
import java.util.List;

public class QuickDedupeOptions {
    private boolean tableHasHeaders;
    private boolean createSheetBackupCopy;
    private boolean skipEmptyCells;
    private List<Integer> columnIndexes = new ArrayList<>();
    private QuickDedupeActionEnumeration action;
    private String range;

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public boolean isCreateSheetBackupCopy() {
        return createSheetBackupCopy;
    }

    public void setCreateSheetBackupCopy(boolean createSheetBackupCopy) {
        this.createSheetBackupCopy = createSheetBackupCopy;
    }

    public boolean isSkipEmptyCells() {
        return skipEmptyCells;
    }

    public void setSkipEmptyCells(boolean skipEmptyCells) {
        this.skipEmptyCells = skipEmptyCells;
    }


    public boolean isTableHasHeaders() {
        return tableHasHeaders;
    }

    public void setTableHasHeaders(boolean tableHasHeaders) {
        this.tableHasHeaders = tableHasHeaders;
    }

    public List<Integer> getColumnIndexes() {
        return columnIndexes;
    }

    public void setColumnIndexes(List<Integer> columnIndexes) {
        this.columnIndexes = columnIndexes;
    }

    public QuickDedupeActionEnumeration getAction() {
        return action;
    }

    public void setAction(QuickDedupeActionEnumeration action) {
        this.action = action;
    }
}
