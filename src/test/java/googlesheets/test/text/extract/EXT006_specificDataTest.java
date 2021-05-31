package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.DataTypeEnumeration;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.Test;

public class EXT006_specificDataTest extends EXTTest {
    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("C2:C50")
                .extractType(ExtractTypeEnumeration.LINKS)
                .specificDataType(DataTypeEnumeration.EMAIL)
                .build();
        execute(options);
        checkResult();
    }
}
