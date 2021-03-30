package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.MERGE_VALUES;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.SEMICOLON;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR011_withoutSkipEmptyCellsOn2stepsTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/13x9Ej_bWbcqhL_qXnyfC97vswqHMTsT8AI1n6k9FmNc/edit#gid=958442167");
    }

    @Test
    public void withoutSkipEmptyCells()  {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F11")
                .dataHasHeaderRow(true)
                .skipEmptyCellsStep3(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, MERGE_VALUES, SEMICOLON))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_011_withoutSkipEmptyCellsOn2steps.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }


}
