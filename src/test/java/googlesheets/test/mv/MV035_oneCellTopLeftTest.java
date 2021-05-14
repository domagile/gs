package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV035_oneCellTopLeftTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1BWRoutI55QpE20Q8rFqJCdmHCQMVRTH2cye6nw-__wM/edit#gid=248878023");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B13:H28")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.LINE_BREAK)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_LEFT_CORNER)
                .clearContentsOfCells(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
