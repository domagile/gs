package googlesheets.service.mergesheets;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.model.mergesheets.ColumnDisplayEnumeration;
import googlesheets.model.mergesheets.MergeSheetsActionEnumeration;
import googlesheets.model.mergesheets.MergeSheetsResultLocationEnumeration;
import googlesheets.service.generic.addon.FunctionInvocationException;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

import static googlesheets.model.mergesheets.MergeSheetsResultLocationEnumeration.UPDATE_MAIN_TABLE;
import static googlesheets.service.generic.addon.FunctionReinvocationUtil.invokeFunctionWithReinvocation;
import static googlesheets.service.generic.addon.GenericAddonService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.google.TableHelper.selectPairsInTable;
import static googlesheets.service.generic.google.TableHelper.selectTriplesInTable;
import static googlesheets.service.generic.webdriver.FieldHelper.getElement;
import static googlesheets.service.generic.webdriver.Locators.TAG_SELECT;

public class MergeSheetsService {
    public static final String BUTTON_ID_CLOSE = "btnNext";
    public static final String FIELD_ID_LOOKUP_TABLE_RANGE = "txtLookupRange";
    public static final String FIELD_ID_MAIN_TABLE_RANGE = "txtMasterRange";

    public static void setMainSheet(String sheet) {
        selectComboboxValue("selectMasterSheetInternal", sheet);
    }


    public static void setMainTableRange(String range) {
        invokeFunctionWithReinvocation(MergeSheetsService::setTableRange, range, FIELD_ID_MAIN_TABLE_RANGE);
    }

    public static void setLookupTableRange(String range) {
        invokeFunctionWithReinvocation(MergeSheetsService::setTableRange, range, FIELD_ID_LOOKUP_TABLE_RANGE);
    }

    private static void setTableRange(String range, String fieldId) {
        //todo: try to send keys with pause between them
        setText(fieldId, range);
        sleep(3000);
        //fixme: just don't know what to do with range behavior and incorrect selection after inserting of range to range field
        setNameBoxValueFromAddonContext(range);
        sleep(3000);
        if (!isText(fieldId, range) || !getNameBoxValueFromAddonContext().equals(range)) {
            throw new FunctionInvocationException();
        }
    }

    public static void setCreateSheetBackup(boolean value) {
        setCheckboxValue(value, "cbCreateMasterSheetBackupInternal");
    }

    public static void setLookupSpreadsheet(String lookupSpreadsheet, String currentSpreadsheet) {
        if (lookupSpreadsheet != null && !lookupSpreadsheet.equals(currentSpreadsheet)) {
            new MergeSheetsDriveFileChooser().chooseFile(lookupSpreadsheet);
        }
    }

    public static void setLookupSheet(String sheet) {
        WebElement select = getElement("selectLookupSheet").findElement(TAG_SELECT);
        selectComboboxValue(select, sheet);
    }

    public static void setMainTableHasHeaders(boolean value) {
        //checkbox is not updated if we do not wait for some time for clickable label
        setCheckboxValueByLabelClick("cbMasterHasHeadersInternal", value);
    }

    public static void setLookupTableHasHeaders(boolean value) {
        setCheckboxValue(value, "cbLookupHasHeadersInternal");
    }

    public static void setSkipEmptyCells(boolean value) {
        setCheckboxValue(value, "cbIgnoreBlanksInternal");
    }

    public static void setMatchCase(boolean value) {
        setCheckboxValue(value, "cbMatchCaseInternal");
    }

    public static void setMatchingColumns(List<PairSelection<Integer, String>> matchingColumns) {
        selectPairsInTable("tbodyMatchingColumns", matchingColumns, 3);
    }

    public static void setUpdatedColumns(List<TripleSelection<Integer, MergeSheetsActionEnumeration, String>> updatedColumns) {
        List<TripleSelection<Integer, String, String>> columnsWithStrings = updatedColumns.stream()
                .map(column -> new TripleSelection<>(column.getFirst(), column.getSecond().getText(), column.getThird()))
                .collect(Collectors.toList());
        selectTriplesInTable("tbodyChooseAction", columnsWithStrings, 2, 3);
    }

    public static void setAddNonMatchingRows(boolean value)
    {
        setCheckboxValue(value, "cbAddNonMatchingRowsInternal");
    }

    public static void setAddStatusColumn(boolean value)
    {
        setCheckboxValue(value, "cbAddStatusColumnInternal");
    }

    public static void setUpdateOnlyEmptyNewCells(boolean value)
    {
        setCheckboxValue(value, "cbUpdateEmptyCellsInternal");
    }

    public static void setUpdateOnlyIfCellsFromLookupContainData(boolean value)
    {
        setCheckboxValue(value, "cbUpdateIfLookupCellsContainDataInternal");
    }

    public static void setClearBackground(boolean value)
    {
        setCheckboxValue(value, "cbClearBackgroundColorInternal");
    }

    public static void setColorUpdatedCells(boolean value)
    {
        setCheckboxValue(value, "cbUpdatedCellsSetBackgroundColorInternal");
    }

    public static void setResultLocation(MergeSheetsResultLocationEnumeration resultLocation)
    {
        clickRadioButton(resultLocation == UPDATE_MAIN_TABLE ?
                "placeResultToMainTableInput" : "placeResultToNewSpreadsheetInput");
    }


    public static void setColumnDisplay(ColumnDisplayEnumeration columnDisplay)
    {
        selectComboboxValue("selectShowColumnsInternal", columnDisplay.getText());
    }


    public static void clickFinishAndClose() {
        clickFinish();
        waitForCompletionAndClose("matching rows were found", BUTTON_ID_CLOSE);
    }


    private static void clickFinish()
    {
        clickElement("btnNext");
    }
}
