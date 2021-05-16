package googlesheets.test.process.afr.generic;

import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.generic.webdriver.WebDriverService;
import googlesheets.service.technical.file.FileType;
import googlesheets.test.generic.AddonTest;

import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.*;
import static googlesheets.service.technical.file.FileService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;
import static googlesheets.ui.generic.google.SpreadsheetMainMenuUtil.startCSVDownload;

//todo: extend from DefaultSideAddonTest
public class AFRTest extends AddonTest {
    private static final String ETALON_DIR = "process\\advancedfindreplace\\";


    public void execute(AdvancedFindReplaceOptions options) {
        runAdvancedFindAndReplace();
        setSearchIn(options.getSearchInType(), options.getSearchSheetIndexes());

        setSearchString(options.getSearchString());
        setMatchCase(options.isMatchCase());
        setEntireCell(options.isEntireCell());
        setByMask(options.isByMask());

        setValues(options.isValue());
        setFormulas(options.isFormulas());
        setNotes(options.isNotes());
        setHyperlinks(options.isHyperlinks());
        setErrors(options.isErrors());

        clickFindAll();
    }


    //todo: refactor to remove internals as much as possible and use generic method
    protected void checkResult(String resultSheetNamePart) {
        String spreadsheetName = getSpreadsheetName();
        String resultSheetName = getFullSheetName(resultSheetNamePart);
        if (fileExists(spreadsheetName, resultSheetName, FileType.CSV)) {
            throw new IllegalStateException(String.format("File for list %s already exists", resultSheetName));
        }
        WebDriverService.switchDriverToDefaultContent();
        makeSheetActive(resultSheetName);
        startCSVDownload();
        restoreInitialDocumentState(resultSheetName);
        compareFileWithEtalon(spreadsheetName, resultSheetName, getEtalonFileName(spreadsheetName, FileType.CSV));
        removeDownloadedSheetFile(spreadsheetName, resultSheetName, FileType.CSV);
    }


    private String getEtalonFileName(String spreadsheetName, FileType fileType) {
        return ETALON_DIR + spreadsheetName + '.' + fileType.name().toLowerCase();
    }


    protected void restoreInitialDocumentState(String resultListName) {
        removeSheetThroughMenu(resultListName);
    }
}
