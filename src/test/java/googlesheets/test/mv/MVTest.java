package googlesheets.test.mv;

import googlesheets.model.mergevalues.MergeValuesOptions;
import googlesheets.service.mergevalues.MergeValuesService;
import googlesheets.test.generic.DefaultSideAddonTest;

public class MVTest extends DefaultSideAddonTest<MergeValuesOptions> {
    private static final String ETALON_DIR = "mergevalues\\";


    protected MVTest() {
        super(new MergeValuesService(), ETALON_DIR);
    }
}
