package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.Test;

public class MV029_CellsPlaseTopLeftCornerTest extends MVTest{
    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B3:H11")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.SEMICOLON)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_LEFT_CORNER)
                .build();
        execute(options);
        checkExcelResult();
    }
}
