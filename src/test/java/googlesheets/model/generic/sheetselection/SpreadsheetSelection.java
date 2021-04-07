package googlesheets.model.generic.sheetselection;

import java.util.Arrays;
import java.util.List;

public class SpreadsheetSelection {
    private String spreadsheetName;
    private List<Integer> sheetIndexes;


    public SpreadsheetSelection(String spreadsheetName, Integer... sheetIndexes) {
        this.spreadsheetName = spreadsheetName;
        this.sheetIndexes = Arrays.asList(sheetIndexes);
    }


    public String getSpreadsheetName() {
        return spreadsheetName;
    }

    public List<Integer> getSheetIndexes() {
        return sheetIndexes;
    }
}
