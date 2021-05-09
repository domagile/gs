package googlesheets.test.process.afr;

import googlesheets.model.process.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.process.advancedfindreplace.SearchInSelection;
import googlesheets.test.process.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.*;

public class AFR011_value_ByMaskEntireCellTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1tbEWqGXAnvPx1iyewZI2tvNZsqvsTV-YuBYxtCOjbHU/edit#gid=199830560");
    }


    @Test
    public void valuesByMaskEntireCellAllSheets() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchSheetIndexes(2,3)
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchString("Ja* T*")
                .entireCell(true)
                .byMask(true)
                .values(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.EXPORT_ALL_FOUND_ENTRIES);

        checkResult("Export results ");
    }
}
