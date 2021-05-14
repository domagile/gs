package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV033_eachSelectedRowLeftClearTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/13d1vuKUdbQ7hstPycYLWe5oYmwV62E3_XSqchgzDEfw/edit#gid=792635187");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B2:H10")
                .mergeType(MergeTypeEnumeration.SELECTED_ROW)
                .predefinedSeparator(SeparatorEnumeration.SPACE)
                .resultLocation(MergeValuesResultLocationEnumeration.LEFT_CELL)
                .clearContentsOfCells(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
