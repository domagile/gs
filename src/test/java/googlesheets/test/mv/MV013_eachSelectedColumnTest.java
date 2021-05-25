package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.Test;

public class MV013_eachSelectedColumnTest extends MVTest{
    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("C4:F10")
                .mergeType(MergeTypeEnumeration.SELECTED_COLUMN)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_CELL)
                .build();
        execute(options);
        checkExcelResult();
    }
}
