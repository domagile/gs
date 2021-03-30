package googlesheets.test.rd.combineduplicaterows.generic;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.test.rd.generic.RDTest;

import static googlesheets.service.removeduplicates.combineduplicaterows.CombineDuplicateRowsService.*;

public class CDRTest extends RDTest {
    public void execute(CombineDuplicateRowsOptions options) {
        runCombineDuplicateRows();

        setCreateBackupCopyOfSheet(options.isCreateSheetBackupCopy());
        setRange(options.getRange());
        clickNext();

        setDataHasHeaderRow(options.isDataHasHeaderRow());
        setSkipEmptyCellsStep2(options.isSkipEmptyCellsStep2());
        setMatchCase(options.isMatchCase());
        selectColumnsToSearchIn(options.getKeyColumnIndexes());
        clickNext();

        setDeleteDuplicateValues(options.isDeleteDuplicateValues());
        setSkipEmptyCellsStep3(options.isSkipEmptyCellsStep3());
        setSynchronizeAction(options.isSynchronizeAction());

        setColumnsToCompare(options.getMergedColumns());
        clickFinishAndClose();
    }
}

