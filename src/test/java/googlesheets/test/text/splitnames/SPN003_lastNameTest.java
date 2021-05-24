package googlesheets.test.text.splitnames;

import googlesheets.model.text.splitnames.SplitNameOptions;
import googlesheets.model.text.splitnames.SplitNameOptionsBuilder;
import org.junit.Test;

public class SPN003_lastNameTest extends SPNTest {
    @Test
    public void split() {
        SplitNameOptions options = new SplitNameOptionsBuilder()
                .setRange("B4:B86")
                .setLastName(true)
                .build();
        execute(options);
        checkResult();
    }
}
