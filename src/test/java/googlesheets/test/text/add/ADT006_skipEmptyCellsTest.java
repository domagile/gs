package googlesheets.test.text.add;

import googlesheets.model.text.add.AddTextOptionBuilder;
import googlesheets.model.text.add.AddTextOptions;
import googlesheets.model.text.add.PositionEnumeration;
import org.junit.BeforeClass;
import org.junit.Test;

public class ADT006_skipEmptyCellsTest extends ADTTest{
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1npO16Y-lFPAFNsZ68Sjm-GRv2ukBNSoYit7odrOOf3I/edit#gid=1448815627");
    }

    @Test
    public void merge()
    {
        AddTextOptions options = new AddTextOptionBuilder()
                .range("B2:B26")
                .addedText("Dissolves in ")
                .position(PositionEnumeration.BEGINNING)
                .skipEmptyCells(true)
                .build();
        execute(options);
        checkResult();
    }
}
