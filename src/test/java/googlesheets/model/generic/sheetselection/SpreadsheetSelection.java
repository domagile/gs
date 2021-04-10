package googlesheets.model.generic.sheetselection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpreadsheetSelection {
    private String spreadsheetName;
    private List<SheetSelection> sheets;


    public SpreadsheetSelection(String spreadsheetName, Integer... sheetIndexes) {
        this.spreadsheetName = spreadsheetName;
        sheets = Arrays.stream(sheetIndexes).map(SheetSelection::new).collect(Collectors.toList());
    }


    public SpreadsheetSelection(String spreadsheetName, SheetSelection... sheets) {
        this.spreadsheetName = spreadsheetName;
        this.sheets = Arrays.asList(sheets);
    }


    public String getSpreadsheetName() {
        return spreadsheetName;
    }

    public List<SheetSelection> getSheetSelections() {
        return sheets;
    }
}
