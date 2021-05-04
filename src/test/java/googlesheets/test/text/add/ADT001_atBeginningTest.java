package googlesheets.test.text.add;

import googlesheets.model.text.add.AddTextOptionBuilder;
import googlesheets.model.text.add.AddTextOptions;
import googlesheets.model.text.add.PositionEnumeration;
import org.junit.BeforeClass;
import org.junit.Test;

public class ADT001_atBeginningTest extends ADTTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1j2JpBaeFJdyop-YZCS1lf1BU_164w62tVESjBNObovE/edit#gid=1219505134");
    }

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
