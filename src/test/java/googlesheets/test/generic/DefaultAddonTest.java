package googlesheets.test.generic;

import googlesheets.model.generic.ResultLocationProvider;
import googlesheets.service.generic.addon.resultchecker.ResultChecker;
import googlesheets.service.generic.addon.resultchecker.FileResultCheckerImpl;
import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import googlesheets.service.generic.addon.resultchecker.SpreadsheetResultCheckerImpl;
import org.junit.After;

public abstract class DefaultAddonTest extends AddonTest {
    private ResultLocationProvider options;
    private ResultChecker resultChecker;


    protected DefaultAddonTest() {
        resultChecker = new SpreadsheetResultCheckerImpl();
    }


    protected DefaultAddonTest(String etalonDir)
    {
        resultChecker = new FileResultCheckerImpl(etalonDir);
    }


    protected void checkResult() {
        resultChecker.checkResult(getSpreadsheetName(), getUpdatedSheetName());
    }


    protected void checkExcelResult() {
        resultChecker.checkExcelResult(getSpreadsheetName(), getUpdatedSheetName());
    }


    protected void checkNewSpreadsheetResult(ResultInfo resultInfo) {
        resultChecker.checkNewSpreadsheetResult(resultInfo, getSpreadsheetName(), getUpdatedSheetName());
    }


    @After
    public void restoreDocument() {
        if (options.isNewSpreadsheet()) {
            restoreInitialStateForNewSpreadsheetOption();
        } else {
            restoreInitialDocumentState(getUpdatedSheetName());
        }
    }


    protected void restoreInitialStateForNewSpreadsheetOption() {
    }


    protected void restoreInitialDocumentState(String resultListName) {
    }


    protected void setOptions(ResultLocationProvider options) {
        this.options = options;
    }


    protected abstract String getUpdatedSheetName();


    protected ResultChecker getResultChecker() {
        return resultChecker;
    }
}
