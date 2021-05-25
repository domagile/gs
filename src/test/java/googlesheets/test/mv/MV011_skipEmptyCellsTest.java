package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.Test;

public class MV011_skipEmptyCellsTest extends MVTest{
    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("C4:G8")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .customSeparator("@")
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
