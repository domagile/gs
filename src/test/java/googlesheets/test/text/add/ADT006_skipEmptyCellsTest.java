package googlesheets.test.text.add;

import googlesheets.model.text.add.AddTextOptionBuilder;
import googlesheets.model.text.add.AddTextOptions;
import googlesheets.model.text.add.PositionEnumeration;
import org.junit.BeforeClass;
import org.junit.Test;

public class ADT006_skipEmptyCellsTest extends ADTTest{
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
