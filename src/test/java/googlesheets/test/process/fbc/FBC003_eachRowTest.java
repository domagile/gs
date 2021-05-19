package googlesheets.test.process.fbc;

import googlesheets.model.process.functionbycolor.CalculationModeEnumeration;
import googlesheets.model.process.functionbycolor.FunctionByColorEnumeration;
import googlesheets.model.process.functionbycolor.FunctionByColorOptions;
import googlesheets.model.process.functionbycolor.FunctionByColorOptionsBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

public class FBC003_eachRowTest extends FBCTest {
    @Test
    public void insertFunction()
    {
        FunctionByColorOptions options = new FunctionByColorOptionsBuilder()
                .range("B6:C25")
                .fontColorOption(true)
                .fontColorValue("blue")
                .backgroundColorOption(true)
                .backgroundColorValue("light red 3")
                .function(FunctionByColorEnumeration.COUNT)
                .resultRange("D6:D25")
                .calculationMode(CalculationModeEnumeration.EACH_ROW)
                .fillResultsWithColors(true)
                .build();
        execute(options);
        checkResult();
    }
}
