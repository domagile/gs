package googlesheets.test.process.fbc;

import googlesheets.model.process.functionbycolor.CalculationModeEnumeration;
import googlesheets.model.process.functionbycolor.FunctionByColorEnumeration;
import googlesheets.model.process.functionbycolor.FunctionByColorOptions;
import googlesheets.model.process.functionbycolor.FunctionByColorOptionsBuilder;
import org.junit.BeforeClass;
import org.junit.Test;

public class FBC002_eachColumnTest extends FBCTest {
    @Test
    public void insertFunction()
    {
        FunctionByColorOptions options = new FunctionByColorOptionsBuilder()
                .range("B5:C26")
                .fontColorOption(true)
                .fontColorValue("dark red 2")
                .backgroundColorOption(true)
                .backgroundColorValue("light blue 3")
                .function(FunctionByColorEnumeration.SUM)
                .resultRange("F5:G5")
                .calculationMode(CalculationModeEnumeration.EACH_COLUMN)
                .build();
        execute(options);
        checkResult();
    }
}
