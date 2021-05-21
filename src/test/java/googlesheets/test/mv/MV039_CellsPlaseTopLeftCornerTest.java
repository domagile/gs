package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV039_CellsPlaseTopLeftCornerTest extends MVTest{
    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("A1:B30")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.SPACE)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_LEFT_CORNER)
                .clearContentsOfCells(true)
                .mergeCells(true)
                .skipEmptyCells(true)
                .wrapText(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
