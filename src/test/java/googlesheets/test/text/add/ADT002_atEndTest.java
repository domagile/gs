package googlesheets.test.text.add;

import googlesheets.model.text.add.AddTextOptionBuilder;
import googlesheets.model.text.add.AddTextOptions;
import googlesheets.model.text.add.PositionEnumeration;
import org.junit.BeforeClass;
import org.junit.Test;

public class ADT002_atEndTest extends ADTTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1Rc6P0ur2m4QbAiJgjgE6JH569aEyNTKBwfAsq-FjDTc/edit#gid=1286702854");
    }

    @Test
    public void merge()
    {
        AddTextOptions options = new AddTextOptionBuilder()
                .range("C2:C27")
                .addedText(" dissolves")
                .position(PositionEnumeration.END)
                .build();
        execute(options);
        checkResult();
    }
}
