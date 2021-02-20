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

public class RDR003_Step2OptionsTest extends RDTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1A9fMXBoMETJ-UDSQyuzU2PE2ZR1Y0CrKErxLi_dwMy8/edit#gid=1900589725");
    }

    @Test
    public void duplicates_1stOccurrences() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickDuplicatesAnd1stOccurrencesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1);
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_003_step2options_duplicates_1stOccurrences.csv");
    }
}
