package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class EXT037_byStringsTest extends EXTTest {
    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("D3:D49")
                .extractType(ExtractTypeEnumeration.BY_STRINGS)
                .allAfterTextOption(true)
                .allAfterTextValue("AAA")
                .allBeforeTextOption(true)
                .allBeforeTextValue("ZZZ")
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
