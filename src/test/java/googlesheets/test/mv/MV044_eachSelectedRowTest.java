package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class MV044_eachSelectedRowTest extends MVTest {
    @Test
    public void merge() {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("A6:E17")
                .mergeType(MergeTypeEnumeration.SELECTED_ROW)
                .predefinedSeparator(SeparatorEnumeration.SEMICOLON)
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
        clickUndo(5);
    }

}
