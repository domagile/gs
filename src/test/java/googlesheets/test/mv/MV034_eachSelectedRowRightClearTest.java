package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV034_eachSelectedRowRightClearTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1GbAwQLOphizbvZiRofbTkpRo5UntwZavAMjSw0F__80/edit#gid=197173765");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B2:H10")
                .mergeType(MergeTypeEnumeration.SELECTED_ROW)
                .predefinedSeparator(SeparatorEnumeration.SPACE)
                .resultLocation(MergeValuesResultLocationEnumeration.RIGHT_CELL)
                .clearContentsOfCells(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
