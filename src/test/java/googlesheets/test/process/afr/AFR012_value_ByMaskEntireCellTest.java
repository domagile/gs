package googlesheets.test.process.afr;

import googlesheets.model.process.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.process.advancedfindreplace.SearchInSelection;
import googlesheets.test.process.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.*;

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
        checkResult("Export results ");
    }
}
