package googlesheets.service.generic.addon.resultchecker;

import googlesheets.service.technical.api.SpreadsheetService;

import static googlesheets.service.generic.google.GoogleSheetService.getSpreadsheetIdByUrl;
import static googlesheets.service.generic.webdriver.WebDriverService.switchDriverToDefaultContent;

public class SpreadsheetResultCheckerImpl implements ResultChecker {
    @Override
    public void checkResult(String spreadsheetName, String sheetName) {
        switchDriverToDefaultContent();
        SpreadsheetService.compareSheets(getSpreadsheetIdByUrl(), sheetName, "Result");
    }

    @Override
    public void checkExcelResult(String spreadsheetName, String sheetName) {
        checkResult(spreadsheetName, sheetName);
    }

    @Override
    public void checkNewSpreadsheetResult(ResultInfo resultInfo, String spreadsheetName, String resultSheetNamePart) {
        //todo: implement
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
