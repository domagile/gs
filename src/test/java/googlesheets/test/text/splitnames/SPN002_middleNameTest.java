package googlesheets.test.text.splitnames;

import googlesheets.model.text.splitnames.SplitNameOptions;
import googlesheets.model.text.splitnames.SplitNameOptionsBuilder;
import org.junit.Test;

public class SPN002_middleNameTest extends SPNTest {
    @Test
    public void split() {
        SplitNameOptions options = new SplitNameOptionsBuilder()
                .setRange("C4:C83")
                .setMiddleName(true)
                .build();
        execute(options);
        checkResult();
    }
}
