package googlesheets.ui.components;

import googlesheets.model.generic.sheetselection.SheetSelection;
import googlesheets.model.generic.sheetselection.SheetSelectionProvider;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;
import googlesheets.service.generic.addon.sheetselection.EntityList;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;
import static googlesheets.service.generic.webdriver.FieldHelper.getElementByCssSelector;
import static googlesheets.service.generic.webdriver.Locators.*;
import static java.util.stream.Collectors.toList;

public class SheetSelectionPanel {
    public void selectSheets(SheetSelectionProvider selectionProvider)
    {
        if (selectionProvider.getSelectedSpreadsheets().isEmpty()) {
            selectSheetsFromCurrentSpreadsheet(selectionProvider.getSelectedSheets());
        }
        else {
            selectSpreadsheetsToCombine(selectionProvider.getSelectedSpreadsheets());
        }
    }


    private static void selectSheetsFromCurrentSpreadsheet(List<SheetSelection> sheetSelections) {
        List<WebElement> sheetListTRs = getSheetListTRs();
        expandSheetFunction().accept(sheetListTRs.get(0));
        selectEntitiesWithRanges(sheetSelections, sheetListTRs);
    }


    private static void selectSpreadsheetsToCombine(List<SpreadsheetSelection> spreadsheets) {
        List<WebElement> trs = getSheetListTRs();
        List<WebElement> spreadsheetTRs = trs.stream()
                .filter(tr -> isSpreadsheetTR(tr) &&
                        spreadsheets.stream().anyMatch(selection -> selection.getSpreadsheetName().equals(getSpreadsheetNameFromTR(tr))))
                .collect(toList());
        checkSpreadsheetPresenceInList(spreadsheets, spreadsheetTRs);
        spreadsheetTRs.forEach(expandSheetFunction());
        List<Integer> spreadsheetIndexes = spreadsheetTRs.stream().map(trs::indexOf).collect(toList());
        List<List<WebElement>> spreadsheetTRSets = new ArrayList<>(spreadsheetIndexes.size());
        for (int i = 0; i < spreadsheetIndexes.size(); i++) {
            int firstIndex = spreadsheetIndexes.get(i);
            int lastIndex = spreadsheetIndexes.size() - 1 > i ? spreadsheetIndexes.get(i + 1) : trs.size();
            spreadsheetTRSets.add(trs.subList(firstIndex, lastIndex));
        }
        for (int i = 0; i < spreadsheetTRSets.size(); i++) {
            selectEntitiesWithRanges(spreadsheets.get(i).getSheetSelections(), spreadsheetTRSets.get(i));
        }
    }

    private static Consumer<WebElement> expandSheetFunction() {
        return tr -> tr.findElements(TAG_TD).get(0).click();
    }


    private static void selectEntitiesWithRanges(List<SheetSelection> selections, List<WebElement> trs)
    {
        selections.forEach(selection -> {
            if (selection.getRange() != null) {
                WebElement rangeTD = trs.get(selection.getIndex()).findElements(TAG_TD).get(3);
                WebElement input = rangeTD.findElement(TAG_INPUT);
                input.sendKeys(selection.getRange());
                //unstable error of range validation without this delay
                sleep(1000);
            }
            else {
                new EntityList(trs, 1).selectEntity(selection.getIndex(), true, TAG_INPUT);
            }
        });
    }


    private static void checkSpreadsheetPresenceInList(List<SpreadsheetSelection> spreadsheets, List<WebElement> spreadsheetTRs) {
        if (spreadsheetTRs.size() != spreadsheets.size())
            throw new IllegalStateException("Spreadsheet for selection is absent in the list");
    }

    private static boolean isSpreadsheetTR(WebElement tr) {
        return tr.getAttribute("class").contains("spreadsheet");
    }

    private static String getSpreadsheetNameFromTR(WebElement tr) {
        return tr.findElements(TAG_TD).get(2).getText();
    }


    private static List<WebElement> getSheetListTRs() {
        WebElement tBody = getElementByCssSelector(".first-step-table-body");
        List<WebElement> trs = tBody.findElements(TAG_TR);
        //if list is loaded during long time
        while (trs.isEmpty()) {
            sleep(1000);
            trs = tBody.findElements(TAG_TR);
        }
        return trs;
    }
}
