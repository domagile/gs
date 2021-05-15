package googlesheets.ui.text.split;

import googlesheets.model.text.split.SplitTypeEnumeration;
import org.openqa.selenium.WebElement;

import java.util.List;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.webdriver.FieldHelper.getElementByXpath;
import static googlesheets.service.generic.xpath.XPathHelper.textContains;

public class SplitTextDialog {
    public void setSplitType(SplitTypeEnumeration splitType) {
        WebElement label = getElementByXpath(textContains(splitType.getText(), "label"));
        clickElement(label);
    }

    public void setSplitValuesByCharacters() {
        clickRadioButton("radioByCharsInternal");
    }

    public void setSplitValuesByStrings() {
        clickRadioButton("radioByStringsInternal");
    }

    public void setSplitValuesByCapitalLetter() {
        clickRadioButton("radioByCapitalInternal");
    }

    public void setSpace(boolean value) {
        setCheckboxValueByLabelClick("cbSpaceDelimeterInternal", value);
    }

    public void setLineBreak(boolean value) {
        setCheckboxValueByLabelClick("cbLineBreakDelimeterInternal", value);
    }

    public void setComma(boolean value) {
        setCheckboxValueByLabelClick("cbCommaDelimeterInternal", value);
    }

    public void setSemicolon(boolean value) {
        setCheckboxValueByLabelClick("cbSemicolonDelimeterInternal", value);
    }

    public void setCustomOption(boolean value) {
        setCheckboxValueByLabelClick("cbCustomCharDelimiterInternal", value);
    }

    public void setCustomCharacters(String value) {
        setText("csltCustomCharDelimiterInternal", value);
    }

    public void setStrings(List<String> strings) {
        setText("txtAreaSubstrings", String.join("\n", strings));
    }

    public void setMatchCase(boolean value) {
        setCheckboxValueByLabelClick("cbSplitByStringsMatchCase", value);
    }

    public void setTreatConsecutiveDelimitersAsOne(boolean value) {
        setCheckboxValueByLabelClick("cbConsecutiveSplittersInternal", value);
    }

    public void setReplaceSourceData(boolean value) {
        setCheckboxValueByLabelClick("cbMergeSplitReplaceSourceDataInternal", value);
    }

    public void clickSplitButton() {
        clickElement("btnSplit");
    }
}
