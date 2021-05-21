package googlesheets.service.generic.google;

import googlesheets.model.generic.rowselection.PairSelection;
import googlesheets.model.generic.rowselection.TripleSelection;
import googlesheets.service.generic.addon.sheetselection.EntityList;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.List;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;
import static googlesheets.service.generic.webdriver.FieldHelper.getPresentElement;
import static googlesheets.service.generic.webdriver.Locators.*;
import static googlesheets.service.generic.webdriver.Locators.TAG_TR;

public class TableHelper {
    public static void selectRowsInTable(String tableBodyId, By checkboxLocator, Integer... indexes) {
        selectRowsInTable(tableBodyId, checkboxLocator, Arrays.asList(indexes));
    }


    public static void selectRowsInTable(String tableBodyId, By checkboxLocator, List<Integer> indexes) {
        try {
            List<WebElement> trs = getTableTRs(tableBodyId);
            EntityList columns = new EntityList(trs, 0);
            for (int i = 0; i < trs.size(); i++) {
                columns.selectEntity(i, indexes.contains(i + 1), checkboxLocator);
            }
        }
        //when tBody is reloaded by browser and link is not actual
        catch (StaleElementReferenceException e) {
            selectRowsInTable(tableBodyId, checkboxLocator, indexes);
        }
    }


    public static void selectPairsInTable(String tableBodyId, List<PairSelection<Integer, String>> pairs, int stringColumnIndex) {
        try {
            List<WebElement> trs = getTableTRs(tableBodyId);
            EntityList columns = new EntityList(trs, 0);
            By comboboxLocator = TAG_SELECT;
            for (PairSelection<Integer, String> pair : pairs) {
                columns.selectEntity(pair.getFirst() - 1, true, TAG_INPUT);
                columns.setComboboxValue(pair.getFirst() - 1, stringColumnIndex, pair.getSecond(), comboboxLocator);
            }
        }
        //when tBody is reloaded by browser and link is not actual
        catch (StaleElementReferenceException e) {
            selectPairsInTable(tableBodyId, pairs, stringColumnIndex);
        }
    }

    public static void selectTriplesInTable(String tableBodyId, List<TripleSelection<Integer, String, String>> triples,
                                            int firstStringColumnIndex, int secondStringColumnIndex) {
        try {
            List<WebElement> trs = getTableTRs(tableBodyId);
            clearSelection(triples, trs);
            By comboboxLocator = TAG_SELECT;
            EntityList columns = new EntityList(trs, 0);
            for (TripleSelection<Integer, String, String> triple : triples) {
                columns.selectEntity(triple.getFirst() - 1, true, TAG_INPUT);
                columns.setComboboxValue(triple.getFirst() - 1, firstStringColumnIndex, triple.getSecond(), comboboxLocator);
                if (triple.getThird() != null) {
                    columns.setComboboxValue(triple.getFirst() - 1, secondStringColumnIndex, triple.getThird(), comboboxLocator);
                }
            }
        }
        //when tBody is reloaded by browser and link is not actual
        catch (StaleElementReferenceException e) {
            selectTriplesInTable(tableBodyId, triples, firstStringColumnIndex, secondStringColumnIndex);
        }
    }

    private static void clearSelection(List<TripleSelection<Integer, String, String>> triples, List<WebElement> trs) {
        for (int i = 0; i < trs.size(); i++) {
            List<WebElement> inputs = trs.get(i).findElements(TAG_TD).get(0).findElements(TAG_INPUT);
            if (!inputs.isEmpty()) {
                WebElement checkbox = inputs.get(0);
                if (checkbox.isSelected() && !isTripleWithIndexPresent(triples, i)) {
                    //checkbox isDisplayed is false and its not interactable here
                    List<WebElement> clickableCheckboxImages = trs.get(i).findElements(TAG_TD).get(0).findElements(
                            By.className("adx-checkbox-square-image"));
                    clickableCheckboxImages.get(0).click();
                }
            }
        }
    }

    private static boolean isTripleWithIndexPresent(List<TripleSelection<Integer, String, String>> triples, int index) {
        return triples.stream().map(TripleSelection::getFirst).anyMatch(i -> i - 1 == index);
    }

    private static List<WebElement> getTableTRs(String tableBodyId) {
        WebElement tBody = getPresentElement(tableBodyId);
        List<WebElement> trs = tBody.findElements(TAG_TR);
        //if list is loaded during long time
        while (trs.isEmpty()) {
            sleep(1000);
            trs = tBody.findElements(TAG_TR);
        }
        return trs;
    }
}
