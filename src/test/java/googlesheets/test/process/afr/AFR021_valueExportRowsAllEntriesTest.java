package googlesheets.test.process.afr;

import googlesheets.model.process.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.process.advancedfindreplace.SearchInSelection;
import googlesheets.test.process.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;


import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.*;

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

        checkResult("Export results ");
    }


}
