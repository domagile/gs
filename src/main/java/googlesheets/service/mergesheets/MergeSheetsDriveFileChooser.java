package googlesheets.service.mergesheets;

import googlesheets.service.generic.addon.DriveFileChooser;

import static googlesheets.service.generic.google.GoogleSheetService.clickElement;
import static googlesheets.service.generic.google.GoogleSheetService.clickElementByText;

public class MergeSheetsDriveFileChooser extends DriveFileChooser {
    @Override
    protected void clickAddFilesFromDrive() {
        clickElement("selectLookupSpreadSheet");
        clickElementByText("Select spreadsheet from Drive");
    }



}
