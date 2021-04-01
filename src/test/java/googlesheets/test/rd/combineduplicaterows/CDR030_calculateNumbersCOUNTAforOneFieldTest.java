package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.COUNT;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.COUNTA;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR030_calculateNumbersCOUNTAforOneFieldTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/11kVQf5jtNHohuu5uC2SBo98w3Uzql-rlsg7ngk6xcWs/edit#gid=57707917");
    }

    @Test
    public void calculateNumbersCOUNTAforOneField() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F8")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, COUNTA))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_030_calculateNumbersCOUNTAforOneField.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
