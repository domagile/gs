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


public class CDR018_checkDataHasHeaderRowsTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1t7_8NEcRoDd_TX0mSKxXjzZqVyDHgmhyEsKUx8fBSPE/edit#gid=787874363");
    }

    @Test
    public void checkDataHasHeaderRows() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F8")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, MERGE_VALUES, SEMICOLON))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_018_checkDataHasHeaderRows.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }


}
