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

public class RDR005_Step2OptionsTest extends RDTest {
    @BeforeClass
    public static void openDocument() throws InterruptedException {
        GoogleSheetService.openDoc("https://docs.google.com/spreadsheets/d/1nq4et9RlqeWPbg_NpuDjzuFvZlnUjtBU-kCY5DDZtjw/edit#gid=298900807");
    }

    @Test
    public void uniques_1stOccurrences() throws IOException, InterruptedException {
        runFindDuplicateOrUniqueRows();
        setCreateBackupCopyOfSheet(false);
        clickNext();
        clickUniquesAnd1stOccurrencesRadioButton();
        clickNext();
        setMyTableHasHeaders(true);
        setMatchCase(false);
        setSkipEmptyCells(false);
        selectColumnsToSearchIn(1);
        clickNext();
        clickAddStatusColumnRadioButton();
        clickFinishAndClose();
        checkResult("Master", "removeduplicates\\RDR_005_step2options_uniques_1stOccurrences.csv");
    }
}
