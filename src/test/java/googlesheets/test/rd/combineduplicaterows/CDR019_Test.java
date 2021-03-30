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


public class CDR019_Test extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/17hYy3O_1g87pZPbcTj3JBZpF955KH2MxKxFIfSvkZQM/edit#gid=1615884324");
    }

    @Test
    public void checkDataHasHeaderRows() throws IOException {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F11")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, MERGE_VALUES, SEMICOLON))
                .build();
        execute(options);

        checkExcelResult("Master", "combineduplicaterows\\CDR_019_checkDataHasHeaderRows.xlsx");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }


}
