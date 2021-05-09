package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV021_eachSelectedColumnTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1wUFgBk4PFcQRkjoOVOU_Hgg76QAcxZ45HWJq5dn_XnA/edit#gid=1932235897");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("B3:G9")
                .mergeType(MergeTypeEnumeration.SELECTED_COLUMN)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_CELL)
                .wrapText(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
