package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.Test;

public class MV003_clearContentOfCellsTest extends MVTest{
    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("A1:E7")
                .mergeType(MergeTypeEnumeration.SELECTED_COLUMN)
                .predefinedSeparator(SeparatorEnumeration.SEMICOLON)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_CELL)
                .clearContentsOfCells(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
