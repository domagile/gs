package googlesheets.test.process.fbc;

import googlesheets.model.process.functionbycolor.FunctionByColorOptions;
import googlesheets.service.generic.google.GoogleSheetService;
import googlesheets.service.process.functionbycolor.FunctionByColorService;
import googlesheets.test.generic.DefaultSideAddonTest;
import org.junit.Before;

public class FBCTest extends DefaultSideAddonTest<FunctionByColorOptions> {
    private static final String ETALON_DIR = "process\\functionbycolor\\";


    protected FBCTest() {
        super(new FunctionByColorService(), ETALON_DIR);
    }


    @Override
    protected String getSheetName() {
        return "Master1";
    }


    @Before
    public void openSpreadsheet() {
        GoogleSheetService.openSpreadsheetByName(getSpreadsheetName());
    }
}
