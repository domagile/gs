package googlesheets.test.text.extract;

import googlesheets.model.text.common.enums.CharacterTypeEnumeration;
import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class EXT050_firstCharactersTest extends EXTTest {
    @Test
    public void extract() {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("D2:D20")
                .extractType(ExtractTypeEnumeration.FIRST_LAST_CHARACTERS)
                .characterType(CharacterTypeEnumeration.FIRST)
                .characterNumber(20)
                .placeResultToNewColumn(true)
                .clearExtractedText(true)
                .build();
        execute(options);
        checkResult();
    }

    @Override
    protected void restoreInitialDocumentState() {
        clickUndo(2);
    }

}
