package googlesheets.test.mv;

import googlesheets.model.mergevalues.*;
import org.junit.BeforeClass;
import org.junit.Test;

public class MV006_oneCellTest extends MVTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1W58eOoV4NnAzQYCq3vo36n7ToyC2jC_1yRWDBomI4Cs/edit#gid=1535278605");
    }

    @Test
    public void merge()
    {
        MergeValuesOptions options = new MergeValuesOptionBuilder()
                .range("A1:I8")
                .mergeType(MergeTypeEnumeration.ONE_CELL)
                .predefinedSeparator(SeparatorEnumeration.SEMICOLON)
                .resultLocation(MergeValuesResultLocationEnumeration.TOP_LEFT_CORNER)
                .mergeCells(true)
                .wrapText(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
