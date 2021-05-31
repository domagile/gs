package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.DataTypeEnumeration;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.Test;

public class EXT007_URLsLinkTest extends EXTTest {
    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("J1:J59")
                .extractType(ExtractTypeEnumeration.LINKS)
                .specificDataType(DataTypeEnumeration.URL)
                .build();
        execute(options);
        checkResult();
    }
}
