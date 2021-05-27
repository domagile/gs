package googlesheets.test.text.extract;

import googlesheets.model.text.common.enums.CharacterTypeEnumeration;
import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class EXT051_lastCharactersTest extends EXTTest {
    @Test
    public void extract() {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("D3:D49")
                .extractType(ExtractTypeEnumeration.FIRST_LAST_CHARACTERS)
                .characterType(CharacterTypeEnumeration.LAST)
                .characterNumber(10)
                .placeResultToNewColumn(true)
                .build();
        execute(options);
        checkResult();
    }

    @Override
    protected void restoreInitialDocumentState() {
        clickUndo(3);
    }
}
