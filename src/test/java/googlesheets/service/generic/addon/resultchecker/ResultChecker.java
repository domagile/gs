package googlesheets.service.generic.addon.resultchecker;

public interface ResultChecker {
    void checkResult(String spreadsheetName, String sheetName);

    void checkExcelResult(String spreadsheetName, String sheetName);

    void checkNewSpreadsheetResult(ResultInfo resultInfo, String spreadsheetName, String resultSheetNamePart);
}

