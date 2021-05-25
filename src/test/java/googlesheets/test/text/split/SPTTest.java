package googlesheets.test.text.split;

import googlesheets.model.text.split.SplitTextOptions;
import googlesheets.service.text.split.SplitTextService;
import googlesheets.test.generic.DefaultSideAddonTest;

public class SPTTest extends DefaultSideAddonTest<SplitTextOptions> {
    public SPTTest() {
        super(new SplitTextService());
    }


    @Override
    protected String getSheetName() {
        return "Table1";
    }
}
