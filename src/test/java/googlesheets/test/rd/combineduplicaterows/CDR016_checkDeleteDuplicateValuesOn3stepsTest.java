package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.MERGE_VALUES;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.SEMICOLON;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR016_checkDeleteDuplicateValuesOn3stepsTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/11OKAwT8nYdy5g-yE0IhnlZLEn4lQoio7CW0hTtnL7xA/edit#gid=441178906");
    }

    @Test
    public void checkDeleteDuplicateValuesOn3steps() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F11")
                .dataHasHeaderRow(true)
                .deleteDuplicateValues(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, MERGE_VALUES, SEMICOLON))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_016_heckDeleteDuplicateValuesOn3steps.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }


}
