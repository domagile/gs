package googlesheets.test.ms;

import googlesheets.model.mergesheets.MergeSheetsOptions;
import googlesheets.service.generic.addon.resultchecker.ResultInfo;
import googlesheets.service.generic.google.GoogleSheetService;
import googlesheets.service.mergesheets.MergeSheetsRunner;
import googlesheets.test.generic.DefaultAddonTest;
import org.junit.Before;

import static googlesheets.service.generic.google.GoogleSheetService.clickElement;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.mergesheets.MergeSheetsService.*;

public class MSTest extends DefaultAddonTest {
    private static final String MERGE_SHEETS_ETALON_DIR = "mergesheets\\";


    protected MSTest() {
        super(MERGE_SHEETS_ETALON_DIR);
    }


    public ResultInfo execute(MergeSheetsOptions options) {
        setOptions(options);
        runMergeSheets();

        setMainSheet(options.getMainSheet());
        setMainTableRange(options.getMainTableRange());
        setCreateSheetBackup(options.isCreateBackupCopy());
        clickNext();

        setLookupSpreadsheet(options.getLookupSpreadsheet(), getSpreadsheetName());
        setLookupSheet(options.getLookupSheet());
        setLookupTableRange(options.getLookupTableRange());
        clickNext();

        setMainTableHasHeaders(options.isMainTableHasHeaders());
        setLookupTableHasHeaders(options.isLookupTableHasHeaders());
        //Issue with Skip empty cells checkbox is present - probably fields are reloaded at some point and value is lost.
        //Therefore checkboxes are set after matching columns to avoid the issue.
        setMatchingColumns(options.getMatchingColumns());
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


    protected String getUpdatedSheetName()
    {
        return "Master";
    }


    protected void restoreInitialDocumentState(String resultListName)  {
        clickUndo();
    }


    @Before
    public void openSpreadsheet() {
        GoogleSheetService.openSpreadsheetByName(getSpreadsheetName());
    }
}
