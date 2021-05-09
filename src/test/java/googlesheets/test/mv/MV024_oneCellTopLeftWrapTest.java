package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV024_oneCellTopLeftWrapTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1f7Swc7v9ojdiJuYcJkO1GQnQOrSxC-xB_0wCoBag5gE/edit#gid=659552806");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B1:D6")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_LEFT_CORNER)
                .wrapText(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
