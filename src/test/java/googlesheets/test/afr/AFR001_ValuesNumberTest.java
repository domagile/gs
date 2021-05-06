package googlesheets.test.afr;

import googlesheets.model.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;
import static googlesheets.service.generic.google.GoogleSheetService.getResultSheetName;

public class AFR001_ValuesNumberTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
       openDocument("https://docs.google.com/spreadsheets/d/1wXhDHPNarDutnSz-CQk1yaA7D-W6GC3-odsi_-Zf9lw/edit#gid=1061966272");

    }

    @Test
    public void valuesNumber() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2)
                .searchString("600")
                .values(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.EXPORT_ALL_FOUND_ENTRIES);
        String resultListName = getResultSheetName("Export results ");
        checkResult(resultListName, "advancedfindreplace\\AFR_001_valuesNumberAllSheets.csv");
    }
}
