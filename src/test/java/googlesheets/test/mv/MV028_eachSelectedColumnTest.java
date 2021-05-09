package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV028_eachSelectedColumnTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1Gfy2pHSKJ172znq6uO4fCf__bJsrif7_FU08oA7SQmo/edit#gid=2106937509");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B3:H9")
                .mergeType(MergeTypeEnumeration.SELECTED_COLUMN)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_CELL)
                .clearContentsOfCells(true)
                .mergeCells(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
