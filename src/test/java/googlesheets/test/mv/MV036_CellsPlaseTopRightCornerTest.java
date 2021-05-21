package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV036_CellsPlaseTopRightCornerTest extends MVTest{
    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B7:F19")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.LINE_BREAK)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_RIGHT_CORNER)
                .clearContentsOfCells(true)
                .skipEmptyCells(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
