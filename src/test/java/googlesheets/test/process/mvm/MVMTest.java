package googlesheets.test.process.mvm;

import googlesheets.model.process.multiplevlookupmatches.MultipleVlookupMatchesOptions;
import googlesheets.service.process.multiplevlookupmatches.MultipleVlookupMatchesService;
import googlesheets.test.generic.DefaultAddonTest;

public class MVMTest extends DefaultAddonTest {
    private MultipleVlookupMatchesService service = new MultipleVlookupMatchesService();

    protected String getUpdatedSheetName()
    {
        return "Master";
    }


    public void execute(MultipleVlookupMatchesOptions options) {
        service.runAddon();
        service.setOptions(options);
        service.execute();
    }
}
