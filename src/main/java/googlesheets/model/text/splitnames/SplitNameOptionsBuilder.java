package googlesheets.model.text.splitnames;

public class SplitNameOptionsBuilder {
    private String range;
    private boolean columnHasHeader;
    private boolean firstName;
    private boolean middleName;
    private boolean lastName;
    private boolean salutationTitle;
    private boolean nameSuffix;

    public SplitNameOptionsBuilder setRange(String range) {
        this.range = range;
        return this;
    }

    public SplitNameOptionsBuilder setColumnHasHeader(boolean columnHasHeader) {
        this.columnHasHeader = columnHasHeader;
        return this;
    }

    public SplitNameOptionsBuilder setFirstName(boolean firstName) {
        this.firstName = firstName;
        return this;
    }

    public SplitNameOptionsBuilder setMiddleName(boolean middleName) {
        this.middleName = middleName;
        return this;
    }

    public SplitNameOptionsBuilder setLastName(boolean lastName) {
        this.lastName = lastName;
        return this;
    }

    public SplitNameOptionsBuilder setSalutationTitle(boolean salutationTitle) {
        this.salutationTitle = salutationTitle;
        return this;
    }

    public SplitNameOptionsBuilder setNameSuffix(boolean nameSuffix) {
        this.nameSuffix = nameSuffix;
        return this;
    }

    public SplitNameOptions build() {
        SplitNameOptions options = new SplitNameOptions();
        options.setRange(range);
        options.setColumnHasHeader(columnHasHeader);
        options.setFirstName(firstName);
        options.setMiddleName(middleName);
        options.setLastName(lastName);
        options.setSalutationTitle(salutationTitle);
        options.setNameSuffix(nameSuffix);
        return options;
    }
}