package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV030_CellsPlaseTopRightCornerTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1cnVhuablA48gMsAVguHJWtHTSK8zKgPTaQx3mJ_xT7E/edit#gid=855065988");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B3:H11")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.SEMICOLON)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_RIGHT_CORNER)
                .build();
        execute(options);
        checkExcelResult();
    }
}
