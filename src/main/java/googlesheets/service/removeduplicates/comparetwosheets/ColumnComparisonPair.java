package googlesheets.service.removeduplicates.comparetwosheets;

public class ColumnComparisonPair {
    private int firstTableColumnIndex;
    private String secondTableColumnName;


    public ColumnComparisonPair(int firstTableColumnIndex, String secondTableColumnName) {
        this.firstTableColumnIndex = firstTableColumnIndex;
        this.secondTableColumnName = secondTableColumnName;
    }


    public int getFirstTableColumnIndex() {
        return firstTableColumnIndex;
    }

    public String getSecondTableColumnName() {
        return secondTableColumnName;
    }
}
