package googlesheets.test.text.remove;

import googlesheets.model.text.remove.RemoveTextOptions;
import googlesheets.service.generic.google.GoogleSheetService;
import googlesheets.service.text.remove.RemoveTextService;
import googlesheets.test.generic.DefaultSideAddonTest;
import org.junit.Before;

public class RTTest extends DefaultSideAddonTest<RemoveTextOptions> {
    public RTTest() {
        super(new RemoveTextService());
    }


    @Override
    protected String getSheetName() {
        return "Table1";
    }
}
