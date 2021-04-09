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

public class AFR004_ValueTextTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1I1JwBoOYVVj-OaA9pSiGlcvwJQPM6UP7v_NoBlaT72M/edit#gid=1034543723");
    }

    @Test
    public void valuesTextAllSheets() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2, 3)
                .searchString("David T")
                .values(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.EXPORT_ALL_FOUND_ENTRIES);
        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_004_valueTextAllSheets.csv");
    }
}
