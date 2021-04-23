package googlesheets.test.afr;

import googlesheets.model.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;

public class AFR012_value_ByMaskEntireCellTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1-ilTu3IfEfKs1YiXWpSh-VITNbm8wJrEFHtGlFSZSZg/edit#gid=344783695");
    }

    @Test
    public void valuesByMaskEntireCellAllSheets() {

        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchSheetIndexes(2,3)
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchString("???t?T*")
                .entireCell(true)
                .byMask(true)
                .values(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.EXPORT_ALL_FOUND_ENTRIES);
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_012_value_ByMask.csv");



      /*  //todo: replace with CustomTimeoutRule
        WebDriverService.getInstance().getWait().withTimeout(Duration.ofSeconds(60));
        try {
       //     runExportAllFoundEntries();
        }
        finally {
            WebDriverService.getInstance().resetWaitTimeout();
        }*/


    }
}
