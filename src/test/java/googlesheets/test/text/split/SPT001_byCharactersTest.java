package googlesheets.test.text.split;

import googlesheets.model.text.split.SplitTextOptions;
import googlesheets.model.text.split.SplitTextOptionsBuilder;
import googlesheets.model.text.split.SplitValuesTypeEnumeration;
import org.junit.BeforeClass;
import org.junit.Test;

public class SPT001_byCharactersTest extends SPTTest {
    @Test
    public void split() {
        SplitTextOptions options = new SplitTextOptionsBuilder()
                .range("B5:B24")
                .splitValuesType(SplitValuesTypeEnumeration.BY_CHARACTERS)
                .space(true)
                .build();
        execute(options);
        checkResult();
    }
}
