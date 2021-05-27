package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.Test;

public class EXT057_byMaskTest extends EXTTest {
    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("L3:L32")
                .extractType(ExtractTypeEnumeration.BY_MASK)
                .mask("???*les")
                .clearExtractedText(true)
                .build();
        execute(options);
        checkResult();
    }
}
