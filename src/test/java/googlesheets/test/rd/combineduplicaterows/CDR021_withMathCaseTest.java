package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.MERGE_VALUES;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.COMMA;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR021_withMathCaseTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1RywOrtiuSeLj-fAAelr4yX6sWs31fEcN0vbbQGIaKTM/edit#gid=1370553929");
    }

    @Test
    public void withMathCase() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:H10")
                .dataHasHeaderRow(true)
                .matchCase(true)
                .synchronizeAction(true)
                .keyColumnIndexes(1, 2, 3)
                .mergedColumns(new MergedColumn(1, MERGE_VALUES, COMMA),
                        new MergedColumn(2, MERGE_VALUES, COMMA),
                        new MergedColumn(3, MERGE_VALUES, COMMA))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_021_withMathCase.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }


}
