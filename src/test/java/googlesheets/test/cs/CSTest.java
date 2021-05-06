package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.service.combinesheets.CombineSheetsRunner;
import googlesheets.service.combinesheets.CombineSheetsService;
import googlesheets.service.generic.addon.DriveFileChooser;
import googlesheets.service.generic.addon.GenericAddonService;
import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import googlesheets.test.generic.DefaultSpreadsheetTest;

import static googlesheets.service.combinesheets.CombineSheetsService.*;
import static googlesheets.service.generic.google.GoogleSheetService.removeSheetThroughMenu;

public class CSTest extends DefaultSpreadsheetTest {
    public static final String COMBINE_SHEETS_ETALON_DIR = "combinesheets\\";


    protected CSTest() {
        super(COMBINE_SHEETS_ETALON_DIR);
    }

    public ResultInfo execute(CombineSheetsOptions options) {
        setOptions(options);
        runCombineSheets();
        if (!options.getDriveSheets().isEmpty()) {
            DriveFileChooser driveFileChooser = new DriveFileChooser();
            driveFileChooser.chooseFiles(options.getDriveSheets());
        }
        selectSheetsToCombine(options);
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


    protected void selectResultLocation(CombineSheetsOptions options)
    {
        CombineSheetsService.selectResultLocation(options);
    }


    protected void restoreInitialDocumentState(String resultListName)  {
        removeSheetThroughMenu(resultListName);
    }


    private void runCombineSheets() {
        new CombineSheetsRunner().runAddon();
    }


    protected String getUpdatedSheetName()
    {
        return "Combined data";
    }
}
