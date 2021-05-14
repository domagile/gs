package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV036_CellsPlaseTopRightCornerTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/13B6y6zX3dE6qNkLz3cubwmGlU9fMZx_ZOJZpoK69ouw/edit#gid=1063509388");
    }

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
