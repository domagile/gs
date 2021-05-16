package googlesheets.test.text.add;

import googlesheets.model.text.add.AddTextOptions;
import googlesheets.service.text.add.AddTextService;
import googlesheets.test.generic.DefaultSideAddonTest;

public class ADTTest extends DefaultSideAddonTest<AddTextOptions> {
    private static final String ETALON_DIR = "text\\add\\";


    public ADTTest() {
        super(new AddTextService(), ETALON_DIR);
    }


    @Override
    protected String getSheetName() {
        return "Table1";
    }
}
