package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.*;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR052_calculateNumbersSTDEVPwithDuplicatesTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1ojUXf1-pCVDz_kQziZUYGJrmqqrpSkoQ8ka6gynOssk/edit#gid=1243394650");
    }

    @Test
    public void calculateNumbersSTDEVPwithDuplicates() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:H17")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1, 2, 3)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, STDEVP),
                        new MergedColumn(2, CALCULATE_NUMBERS, STDEVP),
                        new MergedColumn(3, CALCULATE_NUMBERS, STDEVP))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_052_calculateNumbersSTDEVPwithDuplicates.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
