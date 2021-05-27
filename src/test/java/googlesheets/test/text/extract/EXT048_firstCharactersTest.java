package googlesheets.test.text.extract;

import googlesheets.model.text.common.enums.CharacterTypeEnumeration;
import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.Test;

public class EXT048_firstCharactersTest extends EXTTest {
    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("A2:A25")
                .extractType(ExtractTypeEnumeration.FIRST_LAST_CHARACTERS)
                .characterType(CharacterTypeEnumeration.FIRST)
                .characterNumber(2)
                .placeResultToNewColumn(true)
                .build();
        execute(options);
        checkResult();
    }
}
