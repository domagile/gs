package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV016_eachSelectedColumnTest extends MVTest{
    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("A1:D7")
                .mergeType(MergeTypeEnumeration.SELECTED_COLUMN)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.BOTTOM_CELL)
                .clearContentsOfCells(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
