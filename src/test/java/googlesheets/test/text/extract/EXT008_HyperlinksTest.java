package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.DataTypeEnumeration;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.Test;

public class EXT008_HyperlinksTest extends EXTTest {
    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("H1:H59")
                .extractType(ExtractTypeEnumeration.SPECIFIC_DATA)
                .specificDataType(DataTypeEnumeration.HYPERLINK)
                .placeResultToNewColumn(true)
                .build();
        execute(options);
        checkResult();
    }
}
