package googlesheets.test.cons;

import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.service.consolidatesheets.ConsolidateSheetsRunner;
import googlesheets.service.consolidatesheets.ConsolidateSheetsService;
import googlesheets.service.generic.addon.DriveFileChooser;
import googlesheets.service.generic.addon.GenericAddonService;
import googlesheets.service.generic.addon.ResultInfo;
import googlesheets.service.technical.file.FileType;
import googlesheets.test.SpreadsheetTest;
import org.junit.After;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.technical.file.FileService.*;
import static googlesheets.ui.consolidatesheets.ConsolidateSheetsAddonDialog.BUTTON_ID_CLOSE;

public class CONSTest extends SpreadsheetTest {
    public static final String CONSOLIDATE_SHEETS_ETALON_DIR = "consolidatesheets\\";
    private ConsolidateSheetsOptions options;
    private ConsolidateSheetsService service = new ConsolidateSheetsService();

    public ResultInfo execute(ConsolidateSheetsOptions options) {
        this.options = options;
        runConsolidateSheets();
        if (!options.getDriveSheets().isEmpty()) {
            DriveFileChooser driveFileChooser = new DriveFileChooser();
            driveFileChooser.chooseFiles(options.getDriveSheets());
        }
        service.selectSheetsToConsolidate(options);
        service.clickNext();
        service.selectConsolidationOptions(options);
        service.clickNext();
        service.selectUseFormulaOption(options);
        selectResultLocation(options);
        if (options.getResultLocation() == ResultLocation.NEW_SPREADSHEET) {
            service.clickConsolidate();
            return GenericAddonService.waitForNewSpreadsheetAndClose("Open new spreadsheet", BUTTON_ID_CLOSE);
        }
        else {
            service.clickConsolidateAndClose();
            return null;
        }
    }


    protected void selectResultLocation(ConsolidateSheetsOptions options) {
        service.selectResultLocation(options);
    }


    protected void checkResult() {
        startCSVDownload();
        sleep(2000);
        String spreadsheetName = getSpreadsheetName();
        compareFileWithEtalon(spreadsheetName, getUpdatedSheetName(), getEtalonFileName(FileType.CSV));
        removeDownloadedListFile(spreadsheetName, getUpdatedSheetName(), FileType.CSV);
    }


    private String getEtalonFileName(FileType fileType) {
        return CONSOLIDATE_SHEETS_ETALON_DIR + getSpreadsheetName() + '.' + fileType.name().toLowerCase();
    }


    //todo: move the method to generic place
    protected void checkExcelResult() {
        String listName = getUpdatedSheetName();
        if (fileExists(getSpreadsheetName(), listName, FileType.XLSX)) {
            throw new IllegalStateException(String.format("File for list %s already exists", listName));
        }
        startXLSXDownload();
        sleep(2000);
        compareFileWithEtalon(getSpreadsheetName(), listName, getEtalonFileName(FileType.XLSX), FileType.XLSX);
        removeDownloadedListFile(getSpreadsheetName(), listName, FileType.XLSX);
    }

    //todo: create ResultChecker
    protected void checkNewSpreadsheetResult(ResultInfo resultInfo) {
        sleep(1000);
        openDocument(resultInfo.getNewSpreadsheetLink());
        startCSVDownload();
        sleep(2000);
        String listName = getResultListName("Sheet1");
        moveSpreadsheetToTrash();
        String newSpreadsheetName = "New spreadsheet";
        compareFileWithEtalon(newSpreadsheetName, listName, getEtalonFileName(FileType.CSV));
        removeDownloadedListFile(newSpreadsheetName, listName, FileType.CSV);
    }


    protected void restoreInitialStateForNewSpreadsheetOption()
    {
    }


    protected void restoreInitialDocumentState(String resultListName)  {
        removeListThroughMenu(resultListName);
    }


    private void runConsolidateSheets() {
        new ConsolidateSheetsRunner().runAddon();
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
        return "Consolidated data";
    }
}
