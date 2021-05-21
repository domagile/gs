package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV022_eachSelectedColumnTest extends MVTest{
    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("C4:I10")
                .mergeType(MergeTypeEnumeration.SELECTED_COLUMN)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.BOTTOM_CELL)
                .wrapText(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
