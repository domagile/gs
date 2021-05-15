package googlesheets.model.rd.combineduplicaterows;

public class MergedColumn {
    private int index;
    private ActionEnumeration action;
    private DelimiterFunctionEnumeration delimiterFunction;


    public MergedColumn(int index, ActionEnumeration action, DelimiterFunctionEnumeration delimiterFunction) {
        this.index = index;
        this.action = action;
        this.delimiterFunction = delimiterFunction;
    }


    public int getIndex() {
        return index;
    }

    public ActionEnumeration getAction() {
        return action;
    }

    public DelimiterFunctionEnumeration getDelimiterFunction() {
        return delimiterFunction;
    }
}
