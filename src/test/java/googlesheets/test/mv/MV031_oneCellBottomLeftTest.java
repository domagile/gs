package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV031_oneCellBottomLeftTest extends MVTest{
    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B2:I13")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.SEMICOLON)
                .resultLocation(MergeValuesResultLocationEnumeration.BOTTOM_LEFT_CORNER)
                .build();
        execute(options);
        checkExcelResult();
    }
}
