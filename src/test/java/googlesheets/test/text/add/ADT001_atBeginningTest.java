package googlesheets.test.text.add;

import googlesheets.model.text.add.AddTextOptionBuilder;
import googlesheets.model.text.add.AddTextOptions;
import googlesheets.model.text.add.PositionEnumeration;
import org.junit.Test;

public class ADT001_atBeginningTest extends ADTTest{
    @Test
    public void merge()
    {
        AddTextOptions options = new AddTextOptionBuilder()
                .range("A2:A27")
                .addedText("Vitamin ")
                .position(PositionEnumeration.BEGINNING)
                .build();
        execute(options);
        checkResult();
    }
}
