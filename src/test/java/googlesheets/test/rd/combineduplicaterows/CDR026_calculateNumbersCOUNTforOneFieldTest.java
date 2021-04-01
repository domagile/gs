package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.COUNT;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.SUM;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR026_calculateNumbersCOUNTforOneFieldTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1JVai-Y5_pCP74CvXG2F3zp2CEqIBP_MyAJG-LzyEgt8/edit#gid=327400711");
    }

    @Test
    public void calculateNumbersCOUNTforOneField() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:F8")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, COUNT))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_026_calculateNumbersCOUNTforOneField.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
