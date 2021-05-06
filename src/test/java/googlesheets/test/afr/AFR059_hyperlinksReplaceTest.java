package googlesheets.test.afr;

import googlesheets.model.advancedfindreplace.AFRActionEnumeration;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptionBuilder;
import googlesheets.model.advancedfindreplace.AdvancedFindReplaceOptions;
import googlesheets.service.advancedfindreplace.SearchInSelection;
import googlesheets.test.afr.generic.AFRTest;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static googlesheets.service.advancedfindreplace.AdvancedFindReplaceService.*;
import static googlesheets.service.generic.google.GoogleSheetService.*;

public class AFR059_hyperlinksReplaceTest extends AFRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/11pEa5QQFme1KqSfelzOqjyZQKVETXCu5DUE2OCPERI4/edit#gid=606209076");
    }

    @Ignore
    @Test
    public void valuesRepleceAllSheets() {
        AdvancedFindReplaceOptions options = new AdvancedFindReplaceOptionBuilder()
                .searchSheetIndexes(2,3)
                .searchInType(SearchInSelection.SELECTED_LISTS)
                .searchString("bill")

                .values(true)
                .build();
        execute(options);


        setReplaceString("william");
        clickReplace();
        runMenuAction(AFRActionEnumeration.EXPORT_ALL_FOUND_ENTRIES);

        checkResult(getResultSheetName("Export results "), "advancedfindreplace\\AFR_019_valueReplace.csv");
    }


    protected void restoreInitialDocumentState(String resultListName) {
        //fixme: restoration of data should be done through API
        //wait after CSV download start
        sleep(2000);
        clickUndo();
        clickUndo();
        clickUndo();
    }
}
