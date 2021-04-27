package googlesheets.service.generic.addon.sheetselection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static googlesheets.service.generic.webdriver.Locators.TAG_TD;

public class EntityList {
    private List<WebElement> trs;
    private int checkboxColumn;


    public EntityList(List<WebElement> trs, int checkboxColumn)
    {
        this.trs = trs;
        this.checkboxColumn = checkboxColumn;
    }


    public void selectEntity(int position, boolean value, By checkboxLocator)
    {
        WebElement td = trs.get(position).findElements(TAG_TD).get(checkboxColumn);
        WebElement checkbox = td.findElement(checkboxLocator);
        if (checkbox.isSelected() != value) {
            td.click();
        }
    }


    public void selectEntities(List<Integer> positions, boolean value, By checkboxLocator)
    {
        positions.forEach(position -> selectEntity(position, value, checkboxLocator));
    }


    public void setComboboxValue(int row, int column, String value, By comboboxLocator)
    {
        WebElement td = trs.get(row).findElements(TAG_TD).get(column);
        WebElement select = td.findElement(comboboxLocator);
        selectComboboxValue(select, value);
    }


    public void clickEntity(int position)
    {
        trs.get(position).findElements(TAG_TD).get(checkboxColumn).click();
    }
}
