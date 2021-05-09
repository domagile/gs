package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.BeforeClass;
import org.junit.Test;

public class EXT004_numbersTest extends EXTTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1hmRKzuTzQOOpgI9o5Oa0gvzvmqm2U3OppsMoasXlZOU/edit#gid=0");
    }

    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("D1:D50")
                .extractType(ExtractTypeEnumeration.NUMBERS)
                .build();
        execute(options);
        checkExcelResult();
    }
}
