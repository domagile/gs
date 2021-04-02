package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.combinesheets.SheetSelection;
import googlesheets.model.generic.ResultLocation;
import googlesheets.service.combinesheets.CombineSheetsRunner;
import googlesheets.service.generic.addon.GenericAddonService;
import googlesheets.service.generic.addon.ResultInfo;
import googlesheets.service.technical.file.FileType;
import googlesheets.test.SpreadsheetTest;
import org.junit.After;

import static googlesheets.service.combinesheets.CombineSheetsService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.technical.file.FileService.*;

public class CSTest extends SpreadsheetTest {
    public static final String COMBINE_SHEETS_ETALON_DIR = "combinesheets\\";
    private CombineSheetsOptions options;


    public ResultInfo execute(CombineSheetsOptions options) {
        this.options = options;
        runCombineSheets();
        selectSheetsToCombine(options.getCombinedSheets().stream().mapToInt(SheetSelection::getIndex).toArray());
        clickNext();
        selectHowToCopyDataOptions(options);
        selectResultLocation(options);
        if (options.getResultLocation() == ResultLocation.NEW_SPREADSHEET) {
            clickCombine();
            return GenericAddonService.waitForNewSpreadsheetAndClose("Open new spreadsheet", BUTTON_ID_CLOSE);
        }
        else {
            clickCombineAndClose();
            return null;
        }
    }


    protected void checkResult(String etalonFileName) {
        startCSVDownload();
        sleep(2000);
        compareFileWithEtalon(getSpreadsheetName(), getUpdatedSheetName(), getEtalonFileName(etalonFileName));
        removeDownloadedListFile(getSpreadsheetName(), getUpdatedSheetName(), FileType.CSV);
    }

    private String getEtalonFileName(String etalonFileName) {
        return COMBINE_SHEETS_ETALON_DIR + etalonFileName;
    }


    //todo: move the method to generic place
    protected void checkExcelResult(String etalonFileName) {
        String listName = getUpdatedSheetName();
        if (fileExists(getSpreadsheetName(), listName, FileType.XLSX)) {
            throw new IllegalStateException(String.format("File for list %s already exists", listName));
        }
        startXLSXDownload();
        sleep(2000);
        compareFileWithEtalon(getSpreadsheetName(), listName, getEtalonFileName(etalonFileName), FileType.XLSX);
        removeDownloadedListFile(getSpreadsheetName(), listName, FileType.XLSX);
    }

    //todo: create ResultChecker
    protected void checkNewSpreadsheetResult(String etalonFileName, ResultInfo resultInfo) {
        sleep(1000);
        openDocument(resultInfo.getNewSpreadsheetLink());
        startCSVDownload();
        sleep(2000);
        String listName = getResultListName(getUpdatedSheetName());
        moveSpreadsheetToTrash();
        String newSpreadsheetName = "New spreadsheet";
        compareFileWithEtalon(newSpreadsheetName, listName, getEtalonFileName(etalonFileName));
        removeDownloadedListFile(newSpreadsheetName, listName, FileType.CSV);
    }


    protected void restoreInitialStateForNewSpreadsheetOption()
    {
    }


    protected void restoreInitialDocumentState(String resultListName)  {
        removeListThroughMenu(resultListName);
    }


    private void runCombineSheets() {
        new CombineSheetsRunner().runAddon();
    }


    @After
    public void restoreDocument()
    {
        if (options.getResultLocation() == ResultLocation.NEW_SPREADSHEET) {
            restoreInitialStateForNewSpreadsheetOption();
        }
        else {
            restoreInitialDocumentState(getUpdatedSheetName());
        }
    }


    protected String getUpdatedSheetName()
    {
        return "Combined data";
    }
}
