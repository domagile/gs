package googlesheets.ui.text.splitnames;

import static googlesheets.service.generic.google.GoogleSheetService.clickElement;
import static googlesheets.service.generic.google.GoogleSheetService.setCheckboxValueByLabelClick;

public class SplitNameDialog {
    public void setColumnHasHeader(boolean value) {
        setCheckboxValueByLabelClick("cbHasHeaderInternal", value);
    }

    public void setFirstName(boolean value) {
        setCheckboxValueByLabelClick("cbFirstNameInternal", value);
    }

    public void setMiddleName(boolean value) {
        setCheckboxValueByLabelClick("cbMiddleNameInternal", value);
    }

    public void setLastName(boolean value) {
        setCheckboxValueByLabelClick("cbLastNameInternal", value);
    }

    public void setSalutationTitle(boolean value) {
        setCheckboxValueByLabelClick("cbTitleInternal", value);
    }

    public void setNameSuffix(boolean value) {
        setCheckboxValueByLabelClick("cbSuffixInternal", value);
    }

    public void clickSplitButton() {
        clickElement("btnSplitName");
    }
}
