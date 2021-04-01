package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.COUNT;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.MIN;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR038_calculateNumbersMINwithDuplicatesTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1PbIC-NoWZJzxzIoEVx0OLa6gWQG9iknOBB-vfmYeH00/edit#gid=1680297258");
    }

    @Test
    public void calculateNumbersMINwithDuplicates() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:H17")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1, 2, 3)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, MIN),
                        new MergedColumn(2, CALCULATE_NUMBERS, MIN),
                        new MergedColumn(3, CALCULATE_NUMBERS, MIN))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_038_calculateNumbersMINwithDuplicates.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
