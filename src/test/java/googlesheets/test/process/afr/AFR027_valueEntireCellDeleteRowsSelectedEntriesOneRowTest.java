package googlesheets.test.process.afr;

import googlesheets.model.process.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.process.advancedfindreplace.SearchInSelection;
import googlesheets.test.process.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class AFR027_valueEntireCellDeleteRowsSelectedEntriesOneRowTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1pUv9jl_zfwUh6RXe-VyI0deU7G6dYrCPE665-3ai3oI/edit#gid=500328376");

    }


    @Test
    public void valueEntireCellExportSelectedEntriesOneRow() {

        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchSheetIndexes(2, 3)
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchString("FL")
                .entireCell(true)
                .values(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.DELETE_ROWS_WITH_SELECTED_ENTRIES);

        sleep(5000);
        checkResult("Master");

    }

    protected void restoreInitialDocumentState(String resultListName) {
        //fixme: restoration of data should be done through API
        //wait after CSV download start
        sleep(2000);
        clickUndo(5);
    }

}