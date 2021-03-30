package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.*;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.MERGE_VALUES;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.*;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.COMMA;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.SEMICOLON;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.combineduplicaterows.CombineDuplicateRowsService.*;


public class CDR005_Test extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/10rJ7NXI6JqXCIhN1fyeUUU8Xck5SD3-FAPl7LQzJHIA/edit#gid=155352248");
    }

    @Test
    public void checkLineBreak() throws IOException {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:G8")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, MERGE_VALUES, SEMICOLON),
                        new MergedColumn(2, MERGE_VALUES, COMMA),
                        new MergedColumn(3, MERGE_VALUES, SPACE),
                        new MergedColumn(4, MERGE_VALUES, LINE_BREAK))
                .build();
        execute(options);

        checkExcelResult("Master", "combineduplicaterows\\CDR_0005_test.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }


}
