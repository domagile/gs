package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV027_oneCellBottomRightWrapTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1wS0Kpe2mPC1P1HrYMkqHsBpm0xpYGQwL1DjXAuNeL6Q/edit#gid=2029313674");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B2:H20")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.BOTTOM_RIGHT_CORNER)
                .wrapText(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
