package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.service.text.extract.ExtractTextService;
import googlesheets.test.generic.DefaultSideAddonTest;

public class EXTTest extends DefaultSideAddonTest<ExtractTextOptions> {
    private static final String ETALON_DIR = "text\\extract\\";


    public EXTTest() {
        super(new ExtractTextService(), ETALON_DIR);
    }


    @Override
    protected String getSheetName() {
        return "Master1";
    }
}
