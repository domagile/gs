package googlesheets.service.removeduplicates.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.service.generic.addon.sheetselection.EntityList;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.List;

import static googlesheets.service.generic.addon.GenericAddonService.reinvokeFunctionWithDelay;
import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.webdriver.FieldHelper.*;
import static googlesheets.service.generic.webdriver.Locators.TAG_SELECT;
import static googlesheets.service.generic.webdriver.Locators.TAG_TR;
import static googlesheets.service.generic.webdriver.WebDriverService.switchDriverToDefaultContent;

public class CombineDuplicateRowsService {

    public static final String CHECKBOX_ID_CREATE_BACKUP_COPY = "bCreateBackup";
    public static final String BUTTON_ID_NEXT = "combineRowsNext";
    public static final String BUTTON_ID_BACK = "combineRowsBack";


    public static final String INPUT_ID_RANGE = "inputActiveRange";

    public static void setCreateBackupCopyOfSheet(boolean value) {
        setPresentCheckboxValue(value, CHECKBOX_ID_CREATE_BACKUP_COPY);
        sleep(5000);
    }

    public static void runCombineDuplicateRows() {
        new CombineDuplicateRowsRunner().runAddon();
    }

    public static void clickNext() {
        clickElement(BUTTON_ID_NEXT);
    }

    public static void setRange(String range) {
        try {
            WebElement field = getPresentElement(INPUT_ID_RANGE);
            //fixme: replace with some check
            sleep(3000);
            field.clear();
            field.sendKeys(range);
            sleep(2000);
            checkText(range, INPUT_ID_RANGE, CombineDuplicateRowsService::setRange);

        } catch (ElementNotInteractableException e) {
            reinvokeFunctionWithDelay(CombineDuplicateRowsService::setRange, range);
        }
    }

    public static void setSkipEmptyCellsStep2(boolean value) {
        setCheckboxValue(value, "bSkipEmptyCellsDuplicate");
    }

    public static void setMatchCase(boolean value) {
        setCheckboxValue(value, "bCaseSensitive");
    }

    public static void setDataHasHeaderRow(boolean value) {
        setCheckboxValue(value, "bTableHasHeaders");
    }

    public static void selectColumnsToSearchIn(List<Integer> indexes) {
        By checkboxLocator = By.tagName("input");
        selectRowsInTable("secondStepTableBody", checkboxLocator, indexes);
    }

    public static void setDeleteDuplicateValues(boolean value) {
        setCheckboxValue(value, "bDeleteDuplicates");
    }

    public static void setSkipEmptyCellsStep3(boolean value) {
        setCheckboxValue(value, "bSkipEmptyCellsMerge");
    }

    public static void setSynchronizeAction(boolean value) {
        setCheckboxValue(value, "bSynchronizeAction");
    }

    public static void setColumnsToCompare(List<MergedColumn> mergedColumns) {
        By checkboxLocator = By.tagName("input");
        selectColumnsToMerge("thirdStepTableBody", checkboxLocator, mergedColumns);
    }


    private static void selectColumnsToMerge(String tableBodyId, By checkboxLocator, List<MergedColumn> mergedColumns) {
        try {
            waitElementPresent(tableBodyId);
            WebElement tBody = getElement(tableBodyId);
            List<WebElement> trs = tBody.findElements(TAG_TR);
            //if list is loaded during long time
            while (trs.isEmpty()) {
                sleep(1000);
                trs = tBody.findElements(TAG_TR);
            }
            EntityList columns = new EntityList(trs, 0);
            for (MergedColumn mergedColumn : mergedColumns) {
                columns.selectEntity(mergedColumn.getIndex() - 1, true, checkboxLocator);
                columns.setComboboxValue(mergedColumn.getIndex() - 1, 2, mergedColumn.getAction().getText(), TAG_SELECT);

                DelimiterFunctionEnumeration delimiterFunction = mergedColumn.getDelimiterFunction();
                By secondComboboxLocator = getDelimiterFunctionComboboxLocator(delimiterFunction);
                columns.setComboboxValue(mergedColumn.getIndex() - 1, 3, delimiterFunction.getText(), secondComboboxLocator);
            }
        }
        //when tBody is reloaded by browser and link is not actual
        catch (StaleElementReferenceException e) {
            selectColumnsToMerge(tableBodyId, checkboxLocator, mergedColumns);
        }
    }

    private static By getDelimiterFunctionComboboxLocator(DelimiterFunctionEnumeration delimiterFunction) {
        return delimiterFunction.isDelimiter() ? TAG_SELECT : By.xpath("(.//select)[2]");
    }

    public static void clickFinishAndClose() {
        getElement("combineRowsNext").click();
        waitForCompletionAndClose();
    }


    public static void waitForCompletionAndClose() {
        waitText("have been processed");
        sleep(5000);
        clickElement("combineRowsClose");
        switchDriverToDefaultContent();
    }

    private void restoreInitialDocumentState(String listName) {
    }
}
