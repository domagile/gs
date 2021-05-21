package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class MV041_eachSelectedRowInsertNewColumnTest extends MVTest {
    @Test
    public void merge() {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B5:F7")
                .mergeType(MergeTypeEnumeration.SELECTED_ROW)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.LEFT_CELL)
                .insertNewColumn(true)
                .build();
        execute(options);
        checkExcelResult();
    }

    @Override
    protected void restoreInitialDocumentState() {
        clickUndo(2);
    }
}
