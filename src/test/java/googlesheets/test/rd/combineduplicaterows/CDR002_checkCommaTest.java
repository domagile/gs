package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.*;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.MERGE_VALUES;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.*;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.SEMICOLON;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;
import static googlesheets.service.removeduplicates.combineduplicaterows.CombineDuplicateRowsService.*;


public class CDR002_checkCommaTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1tN09V0Oxr1fNsosPla_GsXwCAx6QoNChOTq9t13QllA/edit#gid=1758391715");
    }

    @Test
    public void checkComma() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F8")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, MERGE_VALUES, COMMA))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_002_checkComma.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }


}
