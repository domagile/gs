package googlesheets.test.afr;

import googlesheets.model.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;

public class AFR013_value_ByMaskTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1NXY4ypCyPiz8X8gra2Rij7L57w2KDZySRZGzfJ-WLmg/edit#gid=865051153");
    }

    @Test
    public void valuesByMask() {

        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchSheetIndexes(2,3)
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchString("*@*.com")
                .byMask(true)
                .values(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.EXPORT_ALL_FOUND_ENTRIES);
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_013_value_ByMask.csv");



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
