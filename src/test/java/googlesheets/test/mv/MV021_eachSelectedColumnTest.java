package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.Test;

public class MV021_eachSelectedColumnTest extends MVTest{
    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B3:G9")
                .mergeType(MergeTypeEnumeration.SELECTED_COLUMN)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_CELL)
                .wrapText(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
