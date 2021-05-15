package googlesheets.model.rd.combineduplicaterows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombineDuplicateRowsOptionBuilder {
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


    public CombineDuplicateRowsOptionBuilder createSheetBackupCopy(boolean createSheetBackupCopy)
    {
        this.createSheetBackupCopy = createSheetBackupCopy;
        return this;
    }

    public CombineDuplicateRowsOptionBuilder range(String range)
    {
        this.range = range;
        return this;
    }

    public CombineDuplicateRowsOptionBuilder dataHasHeaderRow(boolean dataHasHeaderRow)
    {
        this.dataHasHeaderRow = dataHasHeaderRow;
        return this;
    }

    public CombineDuplicateRowsOptionBuilder skipEmptyCellsStep2(boolean skipEmptyCellsStep2)
    {
        this.skipEmptyCellsStep2 = skipEmptyCellsStep2;
        return this;
    }

    public CombineDuplicateRowsOptionBuilder matchCase(boolean matchCase)
    {
        this.matchCase = matchCase;
        return this;
    }

    public CombineDuplicateRowsOptionBuilder keyColumnIndexes(Integer... indexes)
    {
        keyColumnIndexes = Arrays.asList(indexes);
        return this;
    }

    public CombineDuplicateRowsOptionBuilder deleteDuplicateValues(boolean deleteDuplicateValues)
    {
        this.deleteDuplicateValues = deleteDuplicateValues;
        return this;
    }

    public CombineDuplicateRowsOptionBuilder skipEmptyCellsStep3(boolean skipEmptyCellsStep3)
    {
        this.skipEmptyCellsStep3 = skipEmptyCellsStep3;
        return this;
    }

    public CombineDuplicateRowsOptionBuilder synchronizeAction(boolean synchronizeAction)
    {
        this.synchronizeAction = synchronizeAction;
        return this;
    }

    public CombineDuplicateRowsOptionBuilder mergedColumns(MergedColumn... mergedColumns)
    {
        this.mergedColumns = Arrays.asList(mergedColumns);
        return this;
    }


    public CombineDuplicateRowsOptions build()
    {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptions();
        options.setCreateSheetBackupCopy(createSheetBackupCopy);
        options.setRange(range);
        options.setDataHasHeaderRow(dataHasHeaderRow);
        options.setSkipEmptyCellsStep2(skipEmptyCellsStep2);
        options.setMatchCase(matchCase);
        options.setKeyColumnIndexes(keyColumnIndexes);
        options.setDeleteDuplicateValues(deleteDuplicateValues);
        options.setSkipEmptyCellsStep3(skipEmptyCellsStep3);
        options.setSynchronizeAction(synchronizeAction);
        options.setMergedColumns(mergedColumns);
        return options;
    }
}
