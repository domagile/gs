package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.service.generic.google.GoogleSheetService;
import googlesheets.service.text.extract.ExtractTextService;
import googlesheets.test.generic.DefaultSideAddonTest;
import org.junit.Before;

public class EXTTest extends DefaultSideAddonTest<ExtractTextOptions> {
    private static final String ETALON_DIR = "text\\extract\\";


    public EXTTest() {
        super(new ExtractTextService(), ETALON_DIR);
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
