package googlesheets.test.rd;

import googlesheets.service.GoogleSheetService;
import googlesheets.test.SpreadsheetTest;
import googlesheets.test.rd.generic.RDTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.FileService.compareFileWithEtalon;
import static googlesheets.service.FileService.removeDownloadedListFile;
import static googlesheets.service.GoogleSheetService.startCSVDownload;
import static googlesheets.service.removeduplicates.RemoveDuplicatesService.*;

public class RDR002_Step2OptionsTest extends RDTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1WOMIAzu80C1QPG6rydREvm9E3F6KcuQmdpLy-NjXpWM/edit#gid=1975763608");
    }


    @Test
    public void duplicates_matchCase() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickDuplicatesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(true);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1);
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_002_step2options_duplicates.csv");
    }
}
