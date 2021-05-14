package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV040_CellsPlaseTopRightCornerTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
       openDocument("https://docs.google.com/spreadsheets/d/1JAX-yVuTMZsPCKfeyz_sqqiCvLTwUdBHkrGCMDn_9xs/edit#gid=924165051");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B1:E13")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.SPACE)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_RIGHT_CORNER)
                .clearContentsOfCells(true)
                .mergeCells(true)
                .skipEmptyCells(true)
                .wrapText(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
