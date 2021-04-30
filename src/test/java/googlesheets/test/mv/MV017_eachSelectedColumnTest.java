package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV017_eachSelectedColumnTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1vnIxnN-plySRtq5W_teq8yvaBu277APlemJSY9wcrPM/edit#gid=590060");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("C3:G9")
                .mergeType(MergeTypeEnumeration.SELECTED_COLUMN)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_CELL)
                .clearContentsOfCells(true)
                .mergeCells(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
