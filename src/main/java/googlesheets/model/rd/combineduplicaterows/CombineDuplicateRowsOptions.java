package googlesheets.model.rd.combineduplicaterows;

import java.util.ArrayList;
import java.util.List;

public class CombineDuplicateRowsOptions {
    private boolean createSheetBackupCopy;
    private String range;
    private boolean dataHasHeaderRow;
    private boolean skipEmptyCellsStep2;
    private boolean matchCase;
    private List<Integer> keyColumnIndexes = new ArrayList<>();
    private boolean deleteDuplicateValues;
    private boolean skipEmptyCellsStep3;
    private boolean synchronizeAction;
    private List<MergedColumn> mergedColumns = new ArrayList<>();


    public boolean isCreateSheetBackupCopy() {
        return createSheetBackupCopy;
    }

    public void setCreateSheetBackupCopy(boolean createSheetBackupCopy) {
        this.createSheetBackupCopy = createSheetBackupCopy;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public boolean isDataHasHeaderRow() {
        return dataHasHeaderRow;
    }

    public void setDataHasHeaderRow(boolean dataHasHeaderRow) {
        this.dataHasHeaderRow = dataHasHeaderRow;
    }

    public boolean isSkipEmptyCellsStep2() {
        return skipEmptyCellsStep2;
    }

    public void setSkipEmptyCellsStep2(boolean skipEmptyCellsStep2) {
        this.skipEmptyCellsStep2 = skipEmptyCellsStep2;
    }

    public boolean isMatchCase() {
        return matchCase;
    }

    public void setMatchCase(boolean matchCase) {
        this.matchCase = matchCase;
    }

    public List<Integer> getKeyColumnIndexes() {
        return keyColumnIndexes;
    }

    public void setKeyColumnIndexes(List<Integer> keyColumnIndexes) {
        this.keyColumnIndexes = keyColumnIndexes;
    }

    public boolean isDeleteDuplicateValues() {
        return deleteDuplicateValues;
    }

    public void setDeleteDuplicateValues(boolean deleteDuplicateValues) {
        this.deleteDuplicateValues = deleteDuplicateValues;
    }

    public boolean isSkipEmptyCellsStep3() {
        return skipEmptyCellsStep3;
    }

    public void setSkipEmptyCellsStep3(boolean skipEmptyCellsStep3) {
        this.skipEmptyCellsStep3 = skipEmptyCellsStep3;
    }

    public boolean isSynchronizeAction() {
        return synchronizeAction;
    }

    public void setSynchronizeAction(boolean synchronizeAction) {
        this.synchronizeAction = synchronizeAction;
    }

    public List<MergedColumn> getMergedColumns() {
        return mergedColumns;
    }

    public void setMergedColumns(List<MergedColumn> mergedColumns) {
        this.mergedColumns = mergedColumns;
    }
}
