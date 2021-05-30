package googlesheets.test.text.modify;

import googlesheets.model.text.modify.ModifyTextOptions;
import googlesheets.service.text.modify.ModifyTextService;
import googlesheets.test.generic.DefaultSideAddonTest;

public class MDTTest extends DefaultSideAddonTest<ModifyTextOptions> {
    public MDTTest() {
        super(new ModifyTextService());
    }


    @Override
    protected String getSheetName() {
        return "Table1";
    }
}
