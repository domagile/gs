package googlesheets.test.text.splitnames;

import googlesheets.model.text.splitnames.SplitNameOptions;
import googlesheets.service.text.splitnames.SplitNameService;
import googlesheets.test.generic.DefaultSideAddonTest;

public class SPNTest extends DefaultSideAddonTest<SplitNameOptions> {
    public SPNTest() {
        super(new SplitNameService());
    }


    @Override
    protected String getSheetName() {
        return "Table1";
    }
}
