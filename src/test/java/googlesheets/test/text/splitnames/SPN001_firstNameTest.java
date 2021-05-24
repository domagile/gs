package googlesheets.test.text.splitnames;

import googlesheets.model.text.splitnames.SplitNameOptions;
import googlesheets.model.text.splitnames.SplitNameOptionsBuilder;
import org.junit.Test;

public class SPN001_firstNameTest extends SPNTest {
    @Test
    public void split() {
        SplitNameOptions options = new SplitNameOptionsBuilder()
                .setRange("B:B")
                .setFirstName(true)
                .build();
        execute(options);
        checkResult();
    }
}
