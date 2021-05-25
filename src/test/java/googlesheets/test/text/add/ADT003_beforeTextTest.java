package googlesheets.test.text.add;

import googlesheets.model.text.add.AddTextOptionBuilder;
import googlesheets.model.text.add.AddTextOptions;
import googlesheets.model.text.add.PositionEnumeration;
import org.junit.Test;

public class ADT003_beforeTextTest extends ADTTest{
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
