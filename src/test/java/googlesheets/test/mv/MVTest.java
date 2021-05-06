package googlesheets.test.mv;

import googlesheets.model.mergevalues.MergeValuesOptions;
import googlesheets.service.mergevalues.MergeValuesService;
import googlesheets.service.technical.file.FileType;
import googlesheets.test.generic.SpreadsheetTest;
import org.junit.After;

import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.service.generic.webdriver.WebDriverService.switchDriverToDefaultContent;
import static googlesheets.service.technical.file.FileService.*;
import static org.junit.Assert.fail;

public class MVTest extends SpreadsheetTest {
    private static final String ETALON_DIR = "mergevalues\\";


    protected MergeValuesService service = new MergeValuesService();


    public void execute(MergeValuesOptions options) {
        service.selectRange(options.getRange());
        service.runMergeValues();
        service.setOptions(options);
        service.merge();
    }


    protected void checkResult() {
        String spreadsheetName = getSpreadsheetName();
        String sheetName = "Master";
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
        String sheetName = "Master";
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
