package googlesheets.service.combinesheets;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SheetList {
    private List<WebElement> trs;


    public SheetList(List<WebElement> trs)
    {
        this.trs = trs;
    }


    public void selectSheet(int position)
    {
        trs.get(position).findElements(By.tagName("td")).get(1).click();
    }
}
