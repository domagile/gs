package googlesheets.test.afr.generic;

import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.generic.webdriver.WebDriverService;
import googlesheets.service.technical.file.FileType;
import googlesheets.test.generic.SpreadsheetTest;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;
import static googlesheets.service.technical.file.FileService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class AFRTest extends SpreadsheetTest {
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
    protected void checkResult(String resultListName, String etalonFile) {
        String spreadsheetName = getSpreadsheetName();
        if (fileExists(spreadsheetName, resultListName, FileType.CSV)) {
            throw new IllegalStateException(String.format("File for list %s already exists", resultListName));
        }
        WebDriverService.switchDriverToDefaultContent();
        makeSheetActive(resultListName);
        startCSVDownload();
        restoreInitialDocumentState(resultListName);
        compareFileWithEtalon(spreadsheetName, resultListName, etalonFile);
        removeDownloadedListFile(spreadsheetName, resultListName, FileType.CSV);
    }


    protected void restoreInitialDocumentState(String resultListName) {
        removeListThroughMenu(resultListName);
    }
}
