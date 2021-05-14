package googlesheets.test.process.fbc;

import googlesheets.model.process.functionbycolor.FunctionByColorOptions;
import googlesheets.service.process.functionbycolor.FunctionByColorService;
import googlesheets.test.generic.DefaultSideAddonTest;

public class FBCTest extends DefaultSideAddonTest<FunctionByColorOptions> {
    private static final String ETALON_DIR = "process\\functionbycolor\\";


    protected FBCTest() {
        super(new FunctionByColorService(), ETALON_DIR);
    }


    @Override
    protected String getSheetName() {
        return "Master1";
    }
}
