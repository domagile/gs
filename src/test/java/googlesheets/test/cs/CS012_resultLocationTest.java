package googlesheets.test.cs;

import googlesheets.model.combinesheets.CombineSheetsOptionBuilder;
import googlesheets.model.combinesheets.CombineSheetsOptions;
import googlesheets.model.generic.ResultLocation;
import googlesheets.service.generic.addon.ResultInfo;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;

public class CS012_resultLocationTest extends CSTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1SOUDdJL7p_-9hTXaespHIF5QbDwnnjsT83GWbAGbLCA/edit#gid=192334885");
    }

    @Ignore
    @Test
    public void customLocationFieldInput() {
        CombineSheetsOptions options = new CombineSheetsOptionBuilder()
                .combinedSheets(1, 2, 3)
                .resultLocation(ResultLocation.CUSTOM_LOCATION)
                .customLocationValue("Table2!B15")
                .build();
        execute(options);
        checkResult("CS_012_customLocationFieldInput.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(3);
    }


    @Override
    protected String getUpdatedSheetName() {
        return "Table2";
    }
}
