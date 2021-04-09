package googlesheets.test.afr;

import googlesheets.model.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;
import static googlesheets.service.generic.google.GoogleSheetService.getResultListName;

public class AFR021_valueExportRowsAllEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1SE-dQAl2bDVBvGd_7LJsRwxmhToRSELDKFkKoA9HlOg/edit#gid=21154533");
    }

    @Test
    public void valuesExportRowsAllEntries() {

        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchSheetIndexes(2)
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchString("600")
                .values(true)
                .build();
        execute(options);
        runMenuAction(AFRActionEnumeration.EXPORT_ROWS_WITH_ALL_ENTRIES);

        checkResult(getResultListName("Export results "), "advancedfindreplace\\AFR_021_valueExportRowsAllEntries.csv");
    }


   
}
