package googlesheets.model.text.splitnames;

import googlesheets.model.generic.SideAddonOptions;

public class SplitNameOptions implements SideAddonOptions {
    private String range;
    private boolean columnHasHeader;
    private boolean firstName;
    private boolean middleName;
    private boolean lastName;
    private boolean salutationTitle;
    private boolean nameSuffix;


    @Override
    public String getRange() {
        return range;
    }

    @Override
    public void setRange(String range) {
        this.range = range;
    }

    public boolean isColumnHasHeader() {
        return columnHasHeader;
    }

    public void setColumnHasHeader(boolean columnHasHeader) {
        this.columnHasHeader = columnHasHeader;
    }

    public boolean isFirstName() {
        return firstName;
    }

    public void setFirstName(boolean firstName) {
        this.firstName = firstName;
    }

    public boolean isMiddleName() {
        return middleName;
    }

    public void setMiddleName(boolean middleName) {
        this.middleName = middleName;
    }

    public boolean isLastName() {
        return lastName;
    }

    public void setLastName(boolean lastName) {
        this.lastName = lastName;
    }

    public boolean isSalutationTitle() {
        return salutationTitle;
    }

    public void setSalutationTitle(boolean salutationTitle) {
        this.salutationTitle = salutationTitle;
    }

    public boolean isNameSuffix() {
        return nameSuffix;
    }

    public void setNameSuffix(boolean nameSuffix) {
        this.nameSuffix = nameSuffix;
    }
}
