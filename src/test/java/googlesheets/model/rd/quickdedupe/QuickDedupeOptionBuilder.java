package googlesheets.model.rd.quickdedupe;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuickDedupeOptionBuilder {
    private boolean tableHasHeaders;
    private boolean createSheetBackupCopy;
    private boolean skipEmptyCells;
    private List<Integer> columnIndexes = new ArrayList<>();
    private QuickDedupeActionEnumeration action;
    private String range;


    public QuickDedupeOptionBuilder createSheetBackupCopy(boolean createSheetBackupCopy)
    {
        this.createSheetBackupCopy = createSheetBackupCopy;
        return this;
    }


    public QuickDedupeOptionBuilder tableHasHeaders(boolean tableHasHeaders)
    {
        this.tableHasHeaders = tableHasHeaders;
        return this;
    }

    public QuickDedupeOptionBuilder skipEmptyCells(boolean skipEmptyCells)
    {
        this.skipEmptyCells = skipEmptyCells;
        return this;
    }

    public QuickDedupeOptionBuilder range(String range)
    {
        this.range = range;
        return this;
    }


    public QuickDedupeOptionBuilder columnIndexes(Integer... indexes)
    {
        columnIndexes = Arrays.asList(indexes);
        return this;
    }


    public QuickDedupeOptionBuilder action(QuickDedupeActionEnumeration action)
    {
        this.action = action;
        return this;
    }


    public QuickDedupeOptions build()
    {
        QuickDedupeOptions options = new QuickDedupeOptions();
        if (action == null) {
            throw new IllegalStateException("Action was not defined");
        }
        options.setRange(range);
        options.setTableHasHeaders(tableHasHeaders);
        options.setSkipEmptyCells(skipEmptyCells);
        options.setCreateSheetBackupCopy(createSheetBackupCopy);
        options.setColumnIndexes(columnIndexes);
        options.setAction(action);
        return options;
    }
}
