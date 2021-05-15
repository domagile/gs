package googlesheets.test.text.split;

import googlesheets.model.text.split.SplitTextOptions;
import googlesheets.service.text.split.SplitTextService;
import googlesheets.test.generic.DefaultSideAddonTest;

public class SPTTest extends DefaultSideAddonTest<SplitTextOptions> {
    private static final String ETALON_DIR = "text\\split\\";


    public SPTTest() {
        super(new SplitTextService(), ETALON_DIR);
    }


    @Override
    protected String getSheetName() {
        return "Table1";
    }
}
