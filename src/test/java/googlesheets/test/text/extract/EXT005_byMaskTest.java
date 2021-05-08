package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.BeforeClass;
import org.junit.Test;

public class EXT005_byMaskTest extends EXTTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1SDWtA5o2C4MO86jrsOaUXi0OxbxprdCFXKyqzNkUQS0/edit#gid=1894854080");
    }

    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("B2:B29")
                .extractType(ExtractTypeEnumeration.BY_MASK)
                .mask("J*")
                .maskMatchCase(true)
                .build();
        execute(options);
        checkResult();
    }
}
