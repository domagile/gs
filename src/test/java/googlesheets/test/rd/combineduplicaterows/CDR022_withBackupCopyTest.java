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


public class CDR022_withBackupCopyTest extends CDRTest {
    @BeforeClass
    public static void openDocument() {
        openDocument("https://docs.google.com/spreadsheets/d/1XWirU8OvjfqdVdJh0mj_PuIqb5uEiMZVR_2XBUejpOg/edit#gid=1696092492");
    }

    @Test
    public void withBackupCopy() {
        CombineDuplicateRowsOptions options = new CombineDuplicateRowsOptionBuilder()
                .range("C3:H17")
                .createSheetBackupCopy(true)
                .dataHasHeaderRow(true)
                .matchCase(true)
                .keyColumnIndexes(1, 2, 3)
                .synchronizeAction(true)
                .mergedColumns(new MergedColumn(1, MERGE_VALUES, COMMA),
                        new MergedColumn(2, MERGE_VALUES, COMMA),
                        new MergedColumn(3, MERGE_VALUES, COMMA))
                .build();
        execute(options);

        checkResult("Master", "combineduplicaterows\\CDR_022_withBackupCopy.csv");
    }

    @Override
    protected void restoreInitialDocumentState(String resultListName) {
        clickUndo(5);
    }


}
