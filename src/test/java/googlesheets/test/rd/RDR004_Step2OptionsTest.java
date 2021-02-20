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

public class RDR004_Step2OptionsTest extends RDTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1EPcs9H1HBMCvOYws-Szu9xgnmUxzvRn7l6l7gQIG8JM/edit#gid=1420693405");
    }


    @Test
    public void uniques() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickUniquesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1);
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_004_step2options_uniques.csv");
    }
}
