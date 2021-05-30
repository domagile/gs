package googlesheets.model.process.multiplevlookupmatches;

import java.util.Arrays;
import java.util.List;

public class MultipleVlookupMatchesOptionsBuilder {
    private String sourceRange;
    private boolean tableHasHeader;
    private RowReturnTypeEnumeration rowReturnType;
    private int rowNumber;
    private List<Integer> columnList;
    private LogicalOperatorEnumeration logicalOperator;
    private List<Condition> conditions;

    public MultipleVlookupMatchesOptionsBuilder setSourceRange(String sourceRange) {
        this.sourceRange = sourceRange;
        return this;
    }

    public MultipleVlookupMatchesOptionsBuilder setTableHasHeader(boolean tableHasHeader) {
        this.tableHasHeader = tableHasHeader;
        return this;
    }

    public MultipleVlookupMatchesOptionsBuilder setRowReturnType(RowReturnTypeEnumeration rowReturnType) {
        this.rowReturnType = rowReturnType;
        return this;
    }

    public MultipleVlookupMatchesOptionsBuilder setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
        return this;
    }

    public MultipleVlookupMatchesOptionsBuilder setColumnList(Integer... columns) {
        this.columnList = Arrays.asList(columns);
        return this;
    }

    public MultipleVlookupMatchesOptionsBuilder setLogicalOperator(LogicalOperatorEnumeration logicalOperator) {
        this.logicalOperator = logicalOperator;
        return this;
    }

    public MultipleVlookupMatchesOptionsBuilder setConditions(Condition... conditions) {
        this.conditions = Arrays.asList(conditions);
        return this;
    }

    public MultipleVlookupMatchesOptions build() {
        MultipleVlookupMatchesOptions options = new MultipleVlookupMatchesOptions();
        options.setSourceRange(sourceRange);
        options.setTableHasHeader(tableHasHeader);
        options.setRowReturnType(rowReturnType);
        options.setRowNumber(rowNumber);
        options.setColumnList(columnList);
        options.setLogicalOperator(logicalOperator);
        options.setConditions(conditions);
        return options;
    }
}