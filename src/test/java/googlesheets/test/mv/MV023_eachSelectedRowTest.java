package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV023_eachSelectedRowTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1Tfc_-0yNoEcBp-jex555ytiZMzPt-ek9itItcViOcmg/edit#gid=1513664303");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("A2:F8")
                .mergeType(MergeTypeEnumeration.SELECTED_ROW)
                .predefinedSeparator(SeparatorEnumeration.COMMA)
                .resultLocation(MergeValuesResultLocationEnumeration.RIGHT_CELL)
                .wrapText(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
