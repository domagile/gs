package googlesheets.model.process.multiplevlookupmatches;

public class Condition {
    private final String variable;
    private final ConditionOperatorEnumeration operator;
    private final String value;


    public Condition(String variable, ConditionOperatorEnumeration operator, String value) {
        this.variable = variable;
        this.operator = operator;
        this.value = value;
    }


    public String getVariable() {
        return variable;
    }

    public ConditionOperatorEnumeration getOperator() {
        return operator;
    }

    public String getValue() {
        return value;
    }
}
