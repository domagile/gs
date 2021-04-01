package googlesheets.test.rd.combineduplicaterows;

import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptionBuilder;
import googlesheets.model.rd.combineduplicaterows.CombineDuplicateRowsOptions;
import googlesheets.model.rd.combineduplicaterows.MergedColumn;
import googlesheets.test.rd.combineduplicaterows.generic.CDRTest;
import org.junit.BeforeClass;
import org.junit.Test;

import static googlesheets.model.rd.combineduplicaterows.ActionEnumeration.CALCULATE_NUMBERS;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.MEDIAN;
import static googlesheets.model.rd.combineduplicaterows.DelimiterFunctionEnumeration.VARP;
import static googlesheets.service.generic.google.GoogleSheetService.clickUndo;


public class CDR059_calculateNumbersMEDIANforAllFieldsTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1gfCaf3hxNt4SWgXlafKeQ2HvEAbj7tmvoq4rrBZbLD0/edit#gid=1342921604");
    }

    @Test
    public void calculateNumbersMEDIANforAllFields() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("A1:K9")
                .dataHasHeaderRow(true)
                .keyColumnIndexes(1)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, CALCULATE_NUMBERS, MEDIAN),
                        new MergedColumn(2, CALCULATE_NUMBERS, MEDIAN),
                        new MergedColumn(3, CALCULATE_NUMBERS, MEDIAN),
                        new MergedColumn(4, CALCULATE_NUMBERS, MEDIAN),
                        new MergedColumn(5, CALCULATE_NUMBERS, MEDIAN),
                        new MergedColumn(6, CALCULATE_NUMBERS, MEDIAN),
                        new MergedColumn(7, CALCULATE_NUMBERS, MEDIAN),
                        new MergedColumn(8, CALCULATE_NUMBERS, MEDIAN),
                        new MergedColumn(9, CALCULATE_NUMBERS, MEDIAN),
                        new MergedColumn(10, CALCULATE_NUMBERS, MEDIAN))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_059_calculateNumbersMEDIANforAllFields.csv");
    }


    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }
}
