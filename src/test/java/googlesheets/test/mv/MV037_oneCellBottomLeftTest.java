package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV037_oneCellBottomLeftTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1WSmMAwWsLD1oIQsUQjkkHyFcosPTC7OK7VJVp-NotFo/edit#gid=104413846");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("A2:D19")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.LINE_BREAK)
                .resultLocation(MergeValuesResultLocationEnumeration.BOTTOM_LEFT_CORNER)
                .clearContentsOfCells(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
