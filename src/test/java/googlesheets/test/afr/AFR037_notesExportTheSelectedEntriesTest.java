package googlesheets.test.afr;

import googlesheets.model.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.runMenuAction;
import static googlesheets.service.generic.google.GoogleSheetService.getResultSheetName;

public class AFR037_notesExportTheSelectedEntriesTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1Jy-FTHbKJ3U59N6ANXgIgK1KoluRTyeJOd3hXo1rk34/edit#gid=125546058");
    }

    @Test
    public void formulaExportTheSelectedEntriesOneRow() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchSheetIndexes(2)
                .searchString("Note")
                .notes(true)
                .build();
        execute(options);

        runMenuAction(AFRActionEnumeration.EXPORT_SELECTED_ENTRIES);
        checkResult(getResultSheetName("Export results "), "advancedfindreplace\\AFR_037_notesExportTheSelectedEntriesOneRow.csv");
    }

}
