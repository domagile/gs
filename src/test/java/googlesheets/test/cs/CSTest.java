package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.combinesheets.SheetSelection;
import googlesheets.service.combinesheets.CombineSheetsRunner;
import googlesheets.service.technical.file.FileType;
import googlesheets.test.SpreadsheetTest;

import java.io.IOException;

import static googlesheets.service.combinesheets.CombineSheetsService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.technical.file.FileService.compareFileWithEtalon;
import static googlesheets.service.technical.file.FileService.removeDownloadedListFile;

public class CSTest extends SpreadsheetTest {

    public static final String COMBINE_SHEETS_ETALON_DIR = "combinesheets\\";

    public void execute(CombineSheetsOptions options) {
        runCombineSheets();
        selectSheetsToCombine(options.getCombinedSheets().stream().mapToInt(SheetSelection::getIndex).toArray());
        clickNext();
        selectHowToCopyDataOptions(options);
        selectResultLocation(options);
        clickCombineAndClose();
    }


    protected void checkResult(String listName, String etalonFileName) {
        startCSVDownload();
        sleep(2000);
        restoreInitialDocumentState(listName);
        compareFileWithEtalon(getSpreadsheetName(), listName, COMBINE_SHEETS_ETALON_DIR + etalonFileName);
        removeDownloadedListFile(getSpreadsheetName(), listName, FileType.CSV);
    }


    protected void checkExcelResult(String listName, String etalonFileName) {
        startXLSXDownload();
        sleep(2000);
        restoreInitialDocumentState(listName);
        compareFileWithEtalon(getSpreadsheetName(), listName, COMBINE_SHEETS_ETALON_DIR + etalonFileName, FileType.XLSX);
        removeDownloadedListFile(getSpreadsheetName(), listName, FileType.XLSX);
    }


    protected void restoreInitialDocumentState(String resultListName)  {
        removeListThroughMenu(resultListName);
    }


    private void runCombineSheets() {
        new CombineSheetsRunner().runAddon();
    }
}
