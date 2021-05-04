package googlesheets.test.text.add;

import googlesheets.model.text.add.AddTextOptionBuilder;
import googlesheets.model.text.add.AddTextOptions;
import googlesheets.model.text.add.PositionEnumeration;
import org.junit.BeforeClass;
import org.junit.Test;

public class ADT003_beforeTextTest extends ADTTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1xe1rguUS3R7Av9e9_P9jW74pqzw5LAYPl_K2EpasTDg/edit#gid=233298694");
    }

    @Test
    public void merge()
    {
        AddTextOptions options = new AddTextOptionBuilder()
                .range("B1:B15")
                .addedText("is a useful ")
                .position(PositionEnumeration.BEFORE_TEXT)
                .positionText("fruit")
                .build();
        execute(options);
        checkResult();
    }
}
