package googlesheets.service.combinesheets;

import googlesheets.service.WebDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.List;

public class EntityList {
    private List<WebElement> trs;
    private int checkboxColumn;


    public EntityList(List<WebElement> trs, int checkboxColumn)
    {
        this.trs = trs;
        this.checkboxColumn = checkboxColumn;
    }


    public void selectEntity(int position, boolean value)
    {
        //fixme: checkbox selector to params
        WebElement td = trs.get(position).findElements(By.tagName("td")).get(checkboxColumn);
        WebElement checkbox = td.findElement(By.className("rd-column-select-checkbox"));
        if (checkbox.isSelected() != value) {
            td.click();
        }
    }


    public void clickEntity(int position)
    {
        trs.get(position).findElements(By.tagName("td")).get(checkboxColumn).click();
    }
}
