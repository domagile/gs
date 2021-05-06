package googlesheets.test.text.add;

import googlesheets.model.text.add.AddTextOptions;
import googlesheets.service.technical.file.FileType;
import googlesheets.service.text.add.AddTextService;
import googlesheets.test.generic.SpreadsheetTest;
import org.junit.After;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.webdriver.WebDriverService.switchDriverToDefaultContent;
import static googlesheets.service.technical.file.FileService.*;
import static org.junit.Assert.fail;

public class ADTTest extends SpreadsheetTest {
    private static final String ETALON_DIR = "text\\add\\";


    protected AddTextService service = new AddTextService();


    public void execute(AddTextOptions options) {
        service.selectRange(options.getRange());
        service.runAddon();
        service.setOptions(options);
        service.execute();
    }


    protected void checkResult() {
        String spreadsheetName = getSpreadsheetName();
        String sheetName = "Table1";
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
        String sheetName = "Table1";
        if (fileExists(spreadsheetName, sheetName, FileType.XLSX)) {
            fail(String.format("File for list %s already exists", sheetName));
        }
        switchDriverToDefaultContent();
        startXLSXDownload();
        compareFileWithEtalon(spreadsheetName, sheetName, getEtalonFileName(spreadsheetName, FileType.XLSX), FileType.XLSX);
        removeDownloadedSheetFile(spreadsheetName, sheetName, FileType.XLSX);
    }


    private String getEtalonFileName(String spreadsheetName, FileType fileType) {
        return ETALON_DIR + spreadsheetName + '.' + fileType.name().toLowerCase();
    }


    @After
    public void restoreDocument() {
        restoreInitialDocumentState();
    }


    protected void restoreInitialDocumentState() {
        clickUndo();
    }
}
