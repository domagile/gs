package googlesheets.test.text.splitnames;

import googlesheets.model.text.splitnames.SplitNameOptions;
import googlesheets.model.text.splitnames.SplitNameOptionsBuilder;
import org.junit.Test;

public class SPN004_salutationTitleTest extends SPNTest {
    @Test
    public void split() {
        SplitNameOptions options = new SplitNameOptionsBuilder()
                .setRange("C2:C88")
                .setSalutationTitle(true)
                .build();
        execute(options);
        checkResult();
    }
}
