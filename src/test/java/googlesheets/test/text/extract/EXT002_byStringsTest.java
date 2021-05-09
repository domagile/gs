package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptionBuilder;
import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.model.text.extract.enums.ExtractTypeEnumeration;
import org.junit.BeforeClass;
import org.junit.Test;

public class EXT002_byStringsTest extends EXTTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/14JTrL1CbcA-JAIfMdDM_GJWEtOlhmpbKDctxoCpEabQ/edit#gid=1894854080");
    }

    @Test
    public void extract()
    {
        ExtractTextOptions options = new ExtractTextOptionBuilder()
                .range("B2:B29")
                .extractType(ExtractTypeEnumeration.BY_STRINGS)
                .allAfterTextOption(true)
                .allAfterTextValue("0 ")
                .allBeforeTextOption(true)
                .allBeforeTextValue("Jr")
                .stringMatchCase(true)
                .placeResultToNewColumn(true)
                .clearExtractedText(true)
                .build();
        execute(options);
        checkResult();
    }
}
