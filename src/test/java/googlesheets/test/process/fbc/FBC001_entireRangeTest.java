package googlesheets.test.process.fbc;

import googlesheets.model.process.functionbycolor.CalculationModeEnumeration;
import googlesheets.model.process.functionbycolor.FunctionByColorEnumeration;
import googlesheets.model.process.functionbycolor.FunctionByColorOptions;
import googlesheets.model.process.functionbycolor.FunctionByColorOptionsBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

public class FBC001_entireRangeTest extends FBCTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1m400-DZeiKogTTnd12043mNvLLZO1vDPzcU2WHORW64/edit#gid=1816629738");
    }

    @Test
    public void insertFunction()
    {
        FunctionByColorOptions options = new FunctionByColorOptionsBuilder()
                .range("B5:B26")
                .colorCell("B8")
                .fontColorOption(true)
                .backgroundColorOption(true)
                .function(FunctionByColorEnumeration.MIN)
                .resultRange("F12")
                .calculationMode(CalculationModeEnumeration.ENTIRE_RANGE)
                .fillResultsWithColors(true)
                .build();
        execute(options);
        checkExcelResult();
    }
}
