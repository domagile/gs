package googlesheets.service.generic.addon;

import java.util.List;

import static googlesheets.service.generic.google.GoogleSheetService.*;

public class DriveFileChooser {
    public void chooseFile(String name) {
        clickAddFilesFromDrive();
        openDriveMenu();
        clickSharedDrives();
        clickListItem("Test cases");
        clickListItem("Files from drive for tests");
        clickListItem(name);
        clickAddButton();
    }


    public void chooseFiles(List<String> names) {
        chooseFile(names.get(0));
        for (int i = 1; i < names.size(); i++) {
            clickAddFilesFromDrive();
            clickListItem(names.get(i));
            clickAddButton();
        }
        sleep(2000);
    }


    private void clickAddFilesFromDrive()
    {
        clickElement("btnAddFiles");
    }


    private void openDriveMenu()
    {
        clickElementByClass("arrow-down");
    }


    private void clickSharedDrives()
    {
        clickElementByAttribute("folder-id", "shared_drive");
    }


    private void clickListItem(String text)
    {
        clickElementByText(text);
    }


    private void clickAddButton()
    {
        clickElement("btnOpenFiles");
    }
}
