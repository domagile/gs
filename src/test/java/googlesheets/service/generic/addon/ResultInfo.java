package googlesheets.service.generic.addon;

public class ResultInfo {
    private String newSpreadsheetLink;


    public ResultInfo(String newSpreadsheetLink) {
        this.newSpreadsheetLink = newSpreadsheetLink;
    }


    public String getNewSpreadsheetLink() {
        return newSpreadsheetLink;
    }

    public void setNewSpreadsheetLink(String newSpreadsheetLink) {
        this.newSpreadsheetLink = newSpreadsheetLink;
    }
}