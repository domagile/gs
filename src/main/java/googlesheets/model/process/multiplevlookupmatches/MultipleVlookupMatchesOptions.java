package googlesheets.model.process.multiplevlookupmatches;

import java.util.ArrayList;
import java.util.List;

public class MultipleVlookupMatchesOptions {
    public static final int SELECT_ALL_COLUMNS = 0;

    private String sourceRange;
    private boolean tableHasHeader;
    private RowReturnTypeEnumeration rowReturnType;
    private int rowNumber;
    private List<Integer> columnList = new ArrayList<>();
    private LogicalOperatorEnumeration logicalOperator;
    private List<Condition> conditions = new ArrayList<>();


    public String getSourceRange() {
        return sourceRange;
    }

    public void setSourceRange(String sourceRange) {
        this.sourceRange = sourceRange;
    }

    public boolean isTableHasHeader() {
        return tableHasHeader;
    }

    public void setTableHasHeader(boolean tableHasHeader) {
        this.tableHasHeader = tableHasHeader;
    }

    public RowReturnTypeEnumeration getRowReturnType() {
        return rowReturnType;
    }

    public void setRowReturnType(RowReturnTypeEnumeration rowReturnType) {
        this.rowReturnType = rowReturnType;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public List<Integer> getColumnList() {
        return columnList;
    }

    public void setColumnList(List<Integer> columnList) {
        this.columnList = columnList;
    }

    public LogicalOperatorEnumeration getLogicalOperator() {
        return logicalOperator;
    }

    public void setLogicalOperator(LogicalOperatorEnumeration logicalOperator) {
        this.logicalOperator = logicalOperator;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }
}
