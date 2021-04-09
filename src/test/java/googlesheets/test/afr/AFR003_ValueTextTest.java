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

public class AFR003_ValueTextTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1hVrBsl92v4XSQSVSCS6lH0_g-ie_lWho2NjbNGFgyP8/edit#gid=2017121442");
    }

    @Test
    public void valuesTextAllSheets() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2, 3)
                .searchString("David")
                .values(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.EXPORT_ALL_FOUND_ENTRIES);
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_003_valueTextAllSheets.csv");
    }
}
