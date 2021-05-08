package googlesheets.test.cons;

import googlesheets.model.consolidatesheets.ConsolidateSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.service.consolidatesheets.ConsolidateSheetsRunner;
import googlesheets.service.consolidatesheets.ConsolidateSheetsService;
import googlesheets.service.generic.addon.DriveFileChooser;
import googlesheets.service.generic.addon.GenericAddonService;
import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import googlesheets.test.generic.DefaultAddonTest;

import static googlesheets.service.generic.google.GoogleSheetService.removeSheetThroughMenu;
import static googlesheets.ui.consolidatesheets.ConsolidateSheetsAddonDialog.BUTTON_ID_CLOSE;

public class CONSTest extends DefaultAddonTest {
    public static final String CONSOLIDATE_SHEETS_ETALON_DIR = "consolidatesheets\\";
    private ConsolidateSheetsService service = new ConsolidateSheetsService();


    protected CONSTest() {
        super(CONSOLIDATE_SHEETS_ETALON_DIR);
    }

    public ResultInfo execute(ConsolidateSheetsOptions options) {
        setOptions(options);
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


    protected void restoreInitialDocumentState(String resultListName)  {
        removeSheetThroughMenu(resultListName);
    }


    private void runConsolidateSheets() {
        new ConsolidateSheetsRunner().runAddon();
    }


    protected String getUpdatedSheetName()
    {
        return "Consolidated data";
    }
}
