package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV026_oneCellTopRightWrapTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1dOH867BWWz8SEy5DKnuthXDr3H1-tDxMfHxKUwt-yhc/edit#gid=1600101334");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B1:D6")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_RIGHT_CORNER)
                .wrapText(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}