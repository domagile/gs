package googlesheets.test.text.splitnames;

import googlesheets.model.text.splitnames.SplitNameOptions;
import googlesheets.model.text.splitnames.SplitNameOptionsBuilder;
import org.junit.Test;

public class SPN005_nameSuffixTest extends SPNTest {
    @Test
    public void split() {
        SplitNameOptions options = new SplitNameOptionsBuilder()
                .setRange("C:C")
                .setNameSuffix(true)
                .build();
        execute(options);
        checkResult();
    }
}
