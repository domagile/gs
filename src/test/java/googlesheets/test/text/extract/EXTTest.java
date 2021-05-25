package googlesheets.test.text.extract;

import googlesheets.model.text.extract.ExtractTextOptions;
import googlesheets.service.technical.api.SpreadsheetService;
import googlesheets.service.text.extract.ExtractTextService;
import googlesheets.test.generic.DefaultSideAddonTest;

import static googlesheets.service.generic.google.GoogleSheetService.getSpreadsheetIdByUrl;
import static googlesheets.service.generic.webdriver.WebDriverService.switchDriverToDefaultContent;

public class EXTTest extends DefaultSideAddonTest<ExtractTextOptions> {
    private static final String ETALON_DIR = "text\\extract\\";


    public EXTTest() {
        super(new ExtractTextService(), ETALON_DIR);
    }


    @Override
    protected String getSheetName() {
        return "Master1";
    }


    protected void checkResult() {
        switchDriverToDefaultContent();
        SpreadsheetService.compareSheets(getSpreadsheetIdByUrl(), getSheetName(), "Result");
    }
}
