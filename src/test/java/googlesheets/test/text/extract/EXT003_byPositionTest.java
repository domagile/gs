package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.BeforeClass;
import org.junit.Test;

public class EXT003_byPositionTest extends EXTTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1LSXxuz9_n5JEsfM7KqZDLJYgei1Zm8UiuW7DRNufxso/edit#gid=1894854080");
    }

    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("B2:B29")
                .extractType(ExtractTypeEnumeration.BY_POSITION)
                .firstCharPosition(3)
                .extractedCharNumberOption(true)
                .extractedCharNumberValue(4)
                .build();
        execute(options);
        checkResult();
    }
}
