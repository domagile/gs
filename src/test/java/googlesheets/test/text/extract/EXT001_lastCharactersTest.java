package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.CharacterTypeEnumeration;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.BeforeClass;
import org.junit.Test;

public class EXT001_lastCharactersTest extends EXTTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1IIeET0nlkZa98oFbSVlYHKXFpnuSlr0haDus515Kz0Y/edit#gid=0");
    }

    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("D1:D50")
                .extractType(ExtractTypeEnumeration.FIRST_LAST_CHARACTERS)
                .characterType(CharacterTypeEnumeration.FIRST)
                .characterNumber(2)
                .build();
        execute(options);
        checkExcelResult();
    }
}
