package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class MV046_eachSelectedColumnTest extends MVTest {
    @Test
    public void merge() {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B2:D8")
                .mergeType(MergeTypeEnumeration.SELECTED_COLUMN)
                .predefinedSeparator(SeparatorEnumeration.SEMICOLON)
                .resultLocation(MergeValuesResultLocationEnumeration.BOTTOM_CELL)
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
        clickUndo(3);
    }
}
