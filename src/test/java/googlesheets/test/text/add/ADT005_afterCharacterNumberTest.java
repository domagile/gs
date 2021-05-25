package googlesheets.test.text.add;

import googlesheets.model.text.add.AddTextOptionBuilder;
import googlesheets.model.text.add.AddTextOptions;
import googlesheets.model.text.add.PositionEnumeration;
import org.junit.Test;

public class ADT005_afterCharacterNumberTest extends ADTTest{
    @Test
    public void merge()
    {
        AddTextOptions options = new AddTextOptionBuilder()
                .range("F3:F7")
                .addedText("2")
                .position(PositionEnumeration.AFTER_CHARACTER_NUMBER)
                .characterNumber(8)
                .build();
        execute(options);
        checkResult();
    }
}
