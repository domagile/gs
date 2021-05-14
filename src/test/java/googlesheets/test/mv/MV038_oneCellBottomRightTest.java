package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV038_oneCellBottomRightTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/10B9wM77WqsZY3MAoqLRVvZP1Vqyurgpebo9kLS2v6Ko/edit#gid=1863481060");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B2:G13")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.LINE_BREAK)
                .resultLocation(MergeValuesResultLocationEnumeration.BOTTOM_RIGHT_CORNER)
                .clearContentsOfCells(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
