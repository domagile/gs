package googlesheets.test.process.afr;

import googlesheets.model.process.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.process.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.process.advancedfindreplace.SearchInSelection;
import googlesheets.test.process.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.process.advancedfindreplace.AdvancedFindReplaceService.*;

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
        checkResult("Export results ");
    }
}
