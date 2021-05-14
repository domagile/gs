package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV032_oneCellBottomRightTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/18qImYqSgYY7kqz9Za8fxAS-rbp0LHcm5mWqfiXTDQLQ/edit#gid=1604374177");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("A3:H14")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.SEMICOLON)
                .resultLocation(MergeValuesResultLocationEnumeration.BOTTOM_RIGHT_CORNER)
                .build();
        execute(options);
        checkExcelResult();
    }
}
