package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class MV043_eachSelectedColumnTest extends MVTest {
    @Test
    public void merge() {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("A2:H9")
                .mergeType(MergeTypeEnumeration.SELECTED_COLUMN)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_CELL)
                .insertNewColumn(true)
                .build();
        execute(options);
        checkExcelResult();
    }

    @Override
    protected void restoreInitialDocumentState() {
        clickUndo(3);
    }
}
