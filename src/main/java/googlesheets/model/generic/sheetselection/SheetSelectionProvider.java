package googlesheets.model.generic.sheetselection;

import java.util.List;

public interface SheetSelectionProvider {
    List<SheetSelection> getSelectedSheets();

    List<SpreadsheetSelection> getSelectedSpreadsheets();
}
