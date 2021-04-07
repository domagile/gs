package googlesheets.model.generic.sheetselection;

public class SheetSelection {
    private int index;
    private String range;


    public SheetSelection(int index) {
        this.index = index;
    }

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
