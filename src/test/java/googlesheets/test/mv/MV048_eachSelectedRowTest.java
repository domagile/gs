package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class MV048_eachSelectedRowTest extends MVTest {
    @Test
    public void merge() {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B4:E16")
                .mergeType(MergeTypeEnumeration.SELECTED_ROW)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.RIGHT_CELL)
                .insertNewColumn(true)
                .clearContentsOfCells(true)
                .skipEmptyCells(true)
                .wrapText(true)
                .build();
        execute(options);
        checkExcelResult();
    }

    @Override
    protected void restoreInitialDocumentState() {
        clickUndo(7);
    }
}
