package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class EXT045_byStringsTest extends EXTTest {
    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("D2:D30")
                .extractType(ExtractTypeEnumeration.BY_STRINGS)
                .allAfterTextOption(true)
                .allAfterTextValue("Roald")
                .clearExtractedText(true)
                .stringMatchCase(true)
                .placeResultToNewColumn(true)
                .build();
        execute(options);
        checkResult();
    }


    @Override
    protected void restoreInitialDocumentState() {
        clickUndo(2);
    }
}
