package googlesheets.service.generic.addon.sheetselection;

import googlesheets.model.generic.sheetselection.SheetSelection;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static googlesheets.service.generic.google.GoogleSheetService.sleep;

public class EntityList {
    public static final By BY_TD_TAG = By.tagName("td");
    private List<WebElement> trs;
    private int checkboxColumn;


    public EntityList(List<WebElement> trs, int checkboxColumn)
    {
        this.trs = trs;
        this.checkboxColumn = checkboxColumn;
    }


    public void selectEntity(int position, boolean value, By checkboxLocator)
    {
        WebElement td = trs.get(position).findElements(BY_TD_TAG).get(checkboxColumn);
        WebElement checkbox = td.findElement(checkboxLocator);
        if (checkbox.isSelected() != value) {
            td.click();
        }
    }


    public void selectEntities(List<Integer> positions, boolean value, By checkboxLocator)
    {
        positions.forEach(position -> selectEntity(position, value, checkboxLocator));
    }


    public void selectEntitiesWithRanges(List<SheetSelection> selections)
    {
        By checkboxLocator = By.tagName("input");
        selections.forEach(selection -> {
            if (selection.getRange() != null) {
                WebElement rangeTD = trs.get(selection.getIndex()).findElements(BY_TD_TAG).get(3);
                WebElement input = rangeTD.findElement(By.tagName("input"));
                input.click();
                input.sendKeys(selection.getRange() + Keys.ENTER);
            }
            else {
                selectEntity(selection.getIndex(), true, checkboxLocator);
            }
        });
    }


    public void setComboboxValue(int row, int column, String value, By comboboxLocator)
    {
        WebElement td = trs.get(row).findElements(BY_TD_TAG).get(column);
        WebElement select = td.findElement(comboboxLocator);
        Select combobox = new Select(select);
        combobox.selectByVisibleText(value);
    }


    public void clickEntity(int position)
    {
        trs.get(position).findElements(BY_TD_TAG).get(checkboxColumn).click();
    }
}
