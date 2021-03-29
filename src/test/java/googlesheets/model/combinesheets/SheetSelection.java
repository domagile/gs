package googlesheets.model.combinesheets;

public class SheetSelection {
    private int index;
    private String range;


    public SheetSelection(int index, String range) {
        this.index = index;
        this.range = range;
    }


    public int getIndex() {
        return index;
    }

    public String getRange() {
        return range;
    }
}
