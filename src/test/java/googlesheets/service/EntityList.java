package googlesheets.service;

import googlesheets.service.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
        WebElement td = trs.get(position).findElements(By.tagName("td")).get(checkboxColumn);
        WebElement checkbox = td.findElement(checkboxLocator);
        if (checkbox.isSelected() != value) {
            td.click();
        }
    }


    public void setComboboxValue(int row, int column, String value, By comboboxLocator)
    {
        WebElement td = trs.get(row).findElements(By.tagName("td")).get(column);
        WebElement select = td.findElement(comboboxLocator);
        Select combobox = new Select(select);
        combobox.selectByVisibleText(value);
    }


    public void clickEntity(int position)
    {
        trs.get(position).findElements(By.tagName("td")).get(checkboxColumn).click();
    }
}
