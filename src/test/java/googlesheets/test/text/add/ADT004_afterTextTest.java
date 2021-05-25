package googlesheets.test.text.add;

import googlesheets.model.text.add.AddTextOptionBuilder;
import googlesheets.model.text.add.AddTextOptions;
import googlesheets.model.text.add.PositionEnumeration;
import org.junit.Test;

public class ADT004_afterTextTest extends ADTTest{
    @Test
    public void merge()
    {
        AddTextOptions options = new AddTextOptionBuilder()
                .range("C1:C17")
                .addedText(" fruit")
                .position(PositionEnumeration.AFTER_TEXT)
                .positionText("is a useful")
                .build();
        execute(options);
        checkResult();
    }
}
