package googlesheets.test.mv;

import googlesheets.model.mergevalues.MergeTypeEnumeration;
import googlesheets.model.mergevalues.MergeValuesOptionBuilder;
import googlesheets.model.mergevalues.MergeValuesOptions;
import googlesheets.model.mergevalues.MergeValuesResultLocationEnumeration;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV012_skipEmptyCellsTest extends MVTest{
    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("C4:G8")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .customSeparator("_txt_")
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
