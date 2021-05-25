package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class EXT011_byStringsBeforeTextTest extends EXTTest {
    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("E1:E59")
                .extractType(ExtractTypeEnumeration.BY_STRINGS)
                .allBeforeTextOption(true)
                .allBeforeTextValue("com")
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
