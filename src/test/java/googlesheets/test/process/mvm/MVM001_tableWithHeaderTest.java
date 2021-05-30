package googlesheets.test.process.mvm;

import googlesheets.model.process.multiplevlookupmatches.MultipleVlookupMatchesOptions;
import googlesheets.model.process.multiplevlookupmatches.MultipleVlookupMatchesOptionsBuilder;
import googlesheets.model.process.multiplevlookupmatches.RowReturnTypeEnumeration;
import org.junit.Test;

public class MVM001_tableWithHeaderTest extends MVMTest {
    @Test
    public void test()
    {
        MultipleVlookupMatchesOptions options = new MultipleVlookupMatchesOptionsBuilder()
                .setSourceRange("A1:O58")
                .setTableHasHeader(true)
                .setRowReturnType(RowReturnTypeEnumeration.ALL)
                .build();
        execute(options);
        checkResult();
    }
}
