package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.Test;

public class EXT054_byMaskTest extends EXTTest {
    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("L3:L31")
                .extractType(ExtractTypeEnumeration.BY_MASK)
                .mask("Val*")
                .maskMatchCase(true)
                .placeResultToNewColumn(true)
                .build();
        execute(options);
        checkResult();
    }
}
