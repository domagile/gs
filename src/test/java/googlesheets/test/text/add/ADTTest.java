package googlesheets.test.text.add;

import googlesheets.model.text.add.AddTextOptions;
import googlesheets.service.technical.file.FileType;
import googlesheets.service.text.add.AddTextService;
import googlesheets.test.generic.DefaultSideAddonTest;

import static googlesheets.service.generic.google.GoogleSheetService.startCSVDownload;
import static googlesheets.service.generic.google.GoogleSheetService.startXLSXDownload;
import static googlesheets.service.generic.webdriver.WebDriverService.switchDriverToDefaultContent;
import static googlesheets.service.technical.file.FileService.*;
import static org.junit.Assert.fail;

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
