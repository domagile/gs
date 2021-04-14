package googlesheets.ui.components;

import googlesheets.model.generic.sheetselection.SheetSelection;
import googlesheets.model.generic.sheetselection.SheetSelectionProvider;
import googlesheets.model.generic.sheetselection.SpreadsheetSelection;
import googlesheets.service.generic.addon.sheetselection.EntityList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static googlesheets.service.generic.google.GoogleSheetService.getElementByCssSelector;
import static googlesheets.service.generic.google.GoogleSheetService.sleep;
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
        EntityList sheetList = expandSheetList();
        sheetList.selectEntitiesWithRanges(sheetSelections);
    }


    private static void selectSpreadsheetsToCombine(List<SpreadsheetSelection> spreadsheets) {
        List<WebElement> trs = getSheetListTRs();
        List<WebElement> spreadsheetTRs = trs.stream()
                .filter(tr -> isSpreadsheetTR(tr) &&
                        spreadsheets.stream().anyMatch(selection -> selection.getSpreadsheetName().equals(getSpreadsheetNameFromTR(tr))))
                .collect(toList());
        checkSpreadsheetPresenceInList(spreadsheets, spreadsheetTRs);
        spreadsheetTRs.forEach(tr -> tr.findElements(By.tagName("td")).get(0).click());
        List<Integer> spreadsheetIndexes = spreadsheetTRs.stream().map(trs::indexOf).collect(toList());
        List<List<WebElement>> spreadsheetTRSets = new ArrayList<>(spreadsheetIndexes.size());
        for (int i = 0; i < spreadsheetIndexes.size(); i++) {
            int firstIndex = spreadsheetIndexes.get(i);
            int lastIndex = spreadsheetIndexes.size() - 1 > i ? spreadsheetIndexes.get(i + 1) : trs.size();
            spreadsheetTRSets.add(trs.subList(firstIndex, lastIndex));
        }
        for (int i = 0; i < spreadsheetTRSets.size(); i++) {
            new EntityList(spreadsheetTRSets.get(i), 1).selectEntitiesWithRanges(spreadsheets.get(i).getSheetSelections());
        }
    }

    private static void checkSpreadsheetPresenceInList(List<SpreadsheetSelection> spreadsheets, List<WebElement> spreadsheetTRs) {
        if (spreadsheetTRs.size() != spreadsheets.size())
            throw new IllegalStateException("Spreadsheet for selection is absent in the list");
    }

    private static boolean isSpreadsheetTR(WebElement tr) {
        return tr.getAttribute("class").contains("spreadsheet");
    }

    private static String getSpreadsheetNameFromTR(WebElement tr) {
        return tr.findElements(By.tagName("td")).get(2).getText();
    }


    private static EntityList expandSheetList() {
        List<WebElement> trs = getSheetListTRs();
        WebElement td = trs.get(0).findElements(By.tagName("td")).get(0);
        td.click();
        return new EntityList(trs, 1);
    }


    private static List<WebElement> getSheetListTRs() {
        WebElement tBody = getElementByCssSelector(".first-step-table-body");
        List<WebElement> trs = tBody.findElements(By.tagName("tr"));
        //if list is loaded during long time
        while (trs.isEmpty()) {
            sleep(1000);
            trs = tBody.findElements(By.tagName("tr"));
        }
        return trs;
    }
}
