package googlesheets.test.ms;

import googlesheets.model.generic.ResultLocation;
import googlesheets.model.mergesheets.MergeSheetsOptions;
import googlesheets.model.mergesheets.MergeSheetsResultLocationEnumeration;
import googlesheets.service.consolidatesheets.ConsolidateSheetsRunner;
import googlesheets.service.generic.addon.ResultInfo;
import googlesheets.service.mergesheets.MergeSheetsRunner;
import googlesheets.service.technical.file.FileType;
import googlesheets.test.SpreadsheetTest;
import org.junit.After;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.mergesheets.MergeSheetsService.*;
import static googlesheets.service.technical.file.FileService.compareFileWithEtalon;
import static googlesheets.service.technical.file.FileService.removeDownloadedListFile;

public class MSTest extends SpreadsheetTest {
    private static final String MERGE_SHEETS_ETALON_DIR = "mergesheets\\";

    private MergeSheetsOptions options;



    public ResultInfo execute(MergeSheetsOptions options) {
        this.options = options;
        runMergeSheets();

        setMainSheet(options.getMainSheet());
        setMainTableRange(options.getMainTableRange());
        setCreateSheetBackup(options.isCreateBackupCopy());
        clickNext();

        setLookupSpreadsheet(options.getLookupSpreadsheet(), getSpreadsheetName());
        setLookupSheet(options.getLookupSheet());
        setLookupTableRange(options.getLookupTableRange());
        clickNext();

        //Issue with Skip empty cells checkbox is present - probably fields are reloaded at some point and value is lost.
        //Therefore checkboxes are set after matching columns to avoid the issue.
        setMatchingColumns(options.getMatchingColumns());
        setMainTableHasHeaders(options.isMainTableHasHeaders());
        setLookupTableHasHeaders(options.isLookupTableHasHeaders());
        setSkipEmptyCells(options.isSkipEmptyCells());
        setMatchCase(options.isMatchCase());
        clickNext();

        setColumnDisplay(options.getColumnDisplay());
        setUpdatedColumns(options.getUpdatedColumns());
        clickNext();

        setAddNonMatchingRows(options.isAddNonMatchingRows());
        setAddStatusColumn(options.isAddStatusColumn());
        setUpdateOnlyEmptyNewCells(options.isUpdateOnlyEmptyNewCells());
        setUpdateOnlyIfCellsFromLookupContainData(options.isUpdateOnlyIfCellsFromLookupContainData());
        setClearBackground(options.isClearBackground());
        setColorUpdatedCells(options.isColorUpdatedCells());
        setResultLocation(options.getResultLocation());
        clickFinishAndClose();
        return null;
    }


    private void clickNext() {
        clickElement("btnNext");
    }


    private void runMergeSheets() {
        new MergeSheetsRunner().runAddon();
    }


    protected void checkResult() {
        startCSVDownload();
        sleep(2000);
        String spreadsheetName = getSpreadsheetName();
        compareFileWithEtalon(spreadsheetName, getUpdatedSheetName(), getEtalonFileName(FileType.CSV));
        removeDownloadedListFile(spreadsheetName, getUpdatedSheetName(), FileType.CSV);
    }


    protected String getUpdatedSheetName()
    {
        return "Master";
    }


    private String getEtalonFileName(FileType fileType) {
        return MERGE_SHEETS_ETALON_DIR + getSpreadsheetName() + '.' + fileType.name().toLowerCase();
    }


    protected void restoreInitialStateForNewSpreadsheetOption()
    {
    }


    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo();
    }


    @After
    public void restoreDocument()
    {
        if (options.getResultLocation() == MergeSheetsResultLocationEnumeration.NEW_SPREADSHEET) {
            restoreInitialStateForNewSpreadsheetOption();
        }
        else {
            restoreInitialDocumentState(getUpdatedSheetName());
        }
    }
}
