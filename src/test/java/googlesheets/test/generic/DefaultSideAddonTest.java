package googlesheets.test.generic;

import googlesheets.model.generic.SideAddonOptions;
import googlesheets.service.generic.addon.SideAddonService;
import googlesheets.service.technical.file.FileType;
import org.junit.After;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.webdriver.WebDriverService.switchDriverToDefaultContent;
import static googlesheets.service.technical.file.FileService.*;
import static googlesheets.service.technical.file.FileService.removeDownloadedSheetFile;
import static org.junit.Assert.fail;

public class DefaultSideAddonTest<T extends SideAddonOptions> extends AddonTest {
    private SideAddonService<T> service;
    private String etalonDir;


    protected DefaultSideAddonTest(SideAddonService<T> service, String etalonDir) {
        this.service = service;
        this.etalonDir = etalonDir;
    }


    public void execute(T options) {
        service.selectRange(options.getRange());
        service.runAddon();
        service.setOptions(options);
        service.execute();
    }


    protected void checkResult() {
        String spreadsheetName = getSpreadsheetName();
        String sheetName = getSheetName();
        if (fileExists(spreadsheetName, sheetName, FileType.CSV)) {
            fail(String.format("File for list %s already exists", sheetName));
        }
        switchDriverToDefaultContent();
        startCSVDownload();
        compareFileWithEtalon(spreadsheetName, sheetName, getEtalonFileName(spreadsheetName, FileType.CSV));
        removeDownloadedSheetFile(spreadsheetName, sheetName, FileType.CSV);
    }


    protected void checkExcelResult() {
        String spreadsheetName = getSpreadsheetName();
        String sheetName = getSheetName();
        if (fileExists(spreadsheetName, sheetName, FileType.XLSX)) {
            fail(String.format("File for list %s already exists", sheetName));
        }
        switchDriverToDefaultContent();
        startXLSXDownload();
        compareFileWithEtalon(spreadsheetName, sheetName, getEtalonFileName(spreadsheetName, FileType.XLSX), FileType.XLSX);
        removeDownloadedSheetFile(spreadsheetName, sheetName, FileType.XLSX);
    }


    private String getEtalonFileName(String spreadsheetName, FileType fileType) {
        return etalonDir + spreadsheetName + '.' + fileType.name().toLowerCase();
    }


    @After
    public void restoreDocument() {
        restoreInitialDocumentState();
    }


    protected void restoreInitialDocumentState() {
        clickUndo();
    }


    protected String getSheetName() {
        return "Master";
    }
}
